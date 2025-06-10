package com.mera.inventarios.infrastructure.client;

import com.mera.inventarios.infrastructure.client.dto.ProductoAttributes;
import com.mera.inventarios.infrastructure.client.dto.ProductoDTO;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;


@Slf4j
@Component
public class ProductoClientAdapter implements ProductClient{

    private final WebClient webClient;

    @Value("${api.productos.url}")
    private String productosUrl;

    public ProductoClientAdapter(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Optional<ProductoAttributes> obtenerDetalleProducto(Long productoId) {
        try {

            String token = "";
            var auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.getCredentials() instanceof String) {
                token = (String) auth.getCredentials();
            }
            log.info("esta mk que productosUrl {}" ,productosUrl);
            ProductoDTO producto = webClient.get()
                    .uri(productosUrl + "/api/productos/{id}", productoId)
                    .header("Authorization", "Bearer " + token)
                    .retrieve()
                    .bodyToMono(ProductoDTO.class)
                    .onErrorResume(e -> {
                        log.error("Error al consultar producto: {}", e.getMessage());
                        return Mono.empty();
                    })
                    .block();

            return Optional.ofNullable(producto != null ? producto.getData().getAttributes() : null);
        } catch (Exception e) {
            log.error("Fallo consultando producto {}", productoId, e);
            return Optional.empty();
        }
    }
}
