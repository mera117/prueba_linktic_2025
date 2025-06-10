# 🧩 Microservicio de Productos

Este microservicio está desarrollado con **Spring Boot 3** y estructurado bajo principios de **arquitectura limpia**. Se encarga de la gestión de productos mediante un conjunto de endpoints **RESTful**, permitiendo **crear, consultar, actualizar y eliminar** entidades de producto. Utiliza **Spring Data JPA** para el acceso a datos sobre una base de datos **PostgreSQL**, asegurando una persistencia eficiente y desacoplada.

## 🌐 Características principales
- **Seguridad:** Implementada mediante un filtro personalizado que verifica una **API Key** en las cabeceras HTTP.
- **Documentación:** Generada automáticamente con **SpringDoc OpenAPI 3**, accesible desde **Swagger UI**.
- **Contenedores:** Configurado para despliegue en **Docker** mediante `docker-compose`.
- **Pruebas:** Implementación de **pruebas unitarias e integración** con JUnit y Mockito.

---

# 📦 Microservicio de Inventario

Este microservicio está desarrollado con **Spring Boot 3** y aplica una **arquitectura hexagonal (ports and adapters)** para desacoplar la lógica del dominio de las tecnologías externas. Se encarga del manejo del **stock de productos**, permitiendo consultar cantidades, registrar ingresos y egresos, y actualizar el inventario según las operaciones de compra o entrada.

## 🌐 Características principales
- **Integración REST:** Consulta productos desde el Microservicio de Productos.
- **Seguridad:** Autenticación mediante **JWT (JSON Web Token)** con validación a través de un filtro de autenticación personalizado.
- **Instrumentación:** Logs estructurados y validaciones centralizadas.
- **Documentación:** Expuesta vía **Swagger UI**.
- **Contenedores:** Preparado para despliegue en **Docker** con `docker-compose`.
- **Pruebas:** Pruebas unitarias e integración con JUnit y Mockito.

---

# 💻 Frontend Angular

El cliente web está desarrollado con **Angular 20**, usando una arquitectura moderna basada en **standalone components**, **zoneless change detection** y preparado para **SSR (Server-Side Rendering)**. Consume los endpoints de los microservicios de **Productos e Inventario**, permitiendo gestión y visualización de inventario en tiempo real.

## 🌐 Características principales
- **Modularidad:** Proyecto estructurado en módulos independientes.
- **Comunicación asíncrona:** Uso de **RxJS y HttpClient** para optimizar solicitudes a los microservicios.
- **Seguridad:** Integración de **JWT** en headers HTTP mediante **HttpInterceptor**.
- **Interfaz amigable:** Diseño **responsivo**, desacoplado del backend y listo para **Docker**.

---

# 📌 Tecnologías Utilizadas

- **Backend:** Java 23, Spring Boot, Spring Data JPA, PostgreSQL, Spring Security (API Key).
- **Frontend:** Angular 20.
- **Documentación:** Swagger/OpenAPI (springdoc-openapi).
- **Pruebas:** JUnit y Mockito.
- **Contenedores:** Docker.

---

# ⚡ Instalación y Ejecución

## 🔹 Requisitos Previos
- Java 17 o superior.
- Maven 3.9.x.
- PostgreSQL.
- Docker (opcional, para despliegue).

## 🔹 Instalación
1. Clona el repositorio:
   ```sh
   git clone <URL-del-repositorio>
   cd producto-service
---

## 🔹 Compila el proyecto:
- ./mvnw clean package

---

## 🔹 Configuración
Edita el archivo application.properties para configurar la conexión a la base de datos y la API Key:


```properties
spring.datasource.url=jdbc:postgresql://postgres-db:5432/test_linktic
spring.datasource.username=postgres
spring.datasource.password=tu_password
service.api.key=tu_api_key
```

---

## Ejecución
Ejecuta la aplicación localmente:
```sh
java -jar target/Productos-0.0.1-SNAPSHOT.jar
java -jar target/Inventarios-0.0.1-SNAPSHOT.jar
```
Por defecto, la aplicación se ejecuta en [http://localhost:8080](http://localhost:8080).

---

## Estructura del Proyectos
```
Inventarios:
    .gitignore
│       aws.xml
│       compiler.xml
│       encodings.xml
│       jarRepositories.xml
│       misc.xml
│       vcs.xml
│       workspace.xml
│
├───.mvn
│   └───wrapper
│           maven-wrapper.properties
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───mera
│   │   │           └───inventarios
│   │   │               │   InventariosApplication.java
│   │   │               │
│   │   │               ├───application
│   │   │               │       InventarioService.java
│   │   │               │
│   │   │               ├───domain
│   │   │               │   ├───model
│   │   │               │   │       Inventario.java
│   │   │               │   │       ProductoInventarioDTO.java
│   │   │               │   │
│   │   │               │   └───repository
│   │   │               │           InventarioRepository.java
│   │   │               │
│   │   │               └───infrastructure
│   │   │                   ├───client
│   │   │                   │   │   ProductClient.java
│   │   │                   │   │   ProductoClientAdapter.java
│   │   │                   │   │
│   │   │                   │   └───dto
│   │   │                   │           ProductoAttributes.java
│   │   │                   │           ProductoData.java
│   │   │                   │           ProductoDTO.java
│   │   │                   │
│   │   │                   ├───config
│   │   │                   │       OpenApiConfig.java
│   │   │                   │       SecurityConfig.java
│   │   │                   │       WebClientConfig.java
│   │   │                   │
│   │   │                   ├───controller
│   │   │                   │   │   InventarioController.java
│   │   │                   │   │
│   │   │                   │   └───response
│   │   │                   │           JsonApiResponse.java
│   │   │                   │
│   │   │                   └───persistence
│   │   │                       ├───entity
│   │   │                       │       InventarioEntity.java
│   │   │                       │
│   │   │                       ├───mapper
│   │   │                       │       InventarioMapper.java
│   │   │                       │
│   │   │                       └───repository
│   │   │                               DataInventarioRepository.java
│   │   │                               InventarioJpaAdapter.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───mera
│                   └───inventarios
│                           InventariosApplicationTests.java
│
└───target
    │   Inventarios-0.0.1-SNAPSHOT.jar
    │   Inventarios-0.0.1-SNAPSHOT.jar.original
    │
    ├───classes
    │   │   application.properties
    │   │
    │   └───com
    │       └───mera
    │           └───inventarios
    │               │   InventariosApplication.class
    │               │
    │               ├───application
    │               │       InventarioService.class
    │               │
    │               ├───domain
    │               │   ├───model
    │               │   │       Inventario.class
    │               │   │       ProductoInventarioDTO.class
    │               │   │
    │               │   └───repository
    │               │           InventarioRepository.class
    │               │
    │               └───infrastructure
    │                   ├───client
    │                   │   │   ProductClient.class
    │                   │   │   ProductoClientAdapter.class
    │                   │   │
    │                   │   └───dto
    │                   │           ProductoAttributes.class
    │                   │           ProductoData.class
    │                   │           ProductoDTO.class
    │                   │
    │                   ├───config
    │                   │       OpenApiConfig.class
    │                   │       SecurityConfig.class
    │                   │       WebClientConfig.class
    │                   │
    │                   ├───controller
    │                   │   │   InventarioController.class
    │                   │   │
    │                   │   └───response
    │                   │           JsonApiResponse$DataWrapper.class
    │                   │           JsonApiResponse.class
    │                   │
    │                   └───persistence
    │                       ├───entity
    │                       │       InventarioEntity.class
    │                       │
    │                       ├───mapper
    │                       │       InventarioMapper.class
    │                       │
    │                       └───repository
    │                               DataInventarioRepository.class
    │                               InventarioJpaAdapter.class
    │
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-archiver
    │       pom.properties
    │
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       │           createdFiles.lst
    │       │           inputFiles.lst
    │       │
    │       └───testCompile
    │           └───default-testCompile
    │                   createdFiles.lst
    │                   inputFiles.lst
    │
    └───test-classes
        └───com
            └───mera
                └───inventarios
                        InventariosApplicationTests.class
---

Productos:

C:.
│   .classpath
│   .gitattributes
│   .gitignore
│   .project
│   deps.txt
│   docker-compose.yml
│   Dockerfile
│   HELP.md
│   mvnw
│   mvnw.cmd
│   pom.xml
│
├───.idea
│       .gitignore
│       aws.xml
│       cfnlintPlugin.xml
│       compiler.xml
│       encodings.xml
│       jarRepositories.xml
│       misc.xml
│       workspace.xml
│
├───.mvn
│   └───wrapper
│           maven-wrapper.properties
│
├───.settings
│       org.eclipse.core.resources.prefs
│       org.eclipse.jdt.core.prefs
│       org.eclipse.m2e.core.prefs
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───mera
│   │   │           └───productos
│   │   │               │   ProductosApplication.java
│   │   │               │
│   │   │               ├───application
│   │   │               │   │   ActualizarProductoUseCase.java
│   │   │               │   │   CrearProductoUseCase.java
│   │   │               │   │   EliminarProductoUseCase.java
│   │   │               │   │   ListarProductosPaginadosUseCase.java
│   │   │               │   │   ObtenerProductoPorIdUseCase.java
│   │   │               │   │
│   │   │               │   └───dto
│   │   │               │           ActualizarProductoDTO.java
│   │   │               │           CrearProductoDTO.java
│   │   │               │
│   │   │               ├───domain
│   │   │               │   ├───model
│   │   │               │   │       Producto.java
│   │   │               │   │
│   │   │               │   └───port
│   │   │               │           ProductoRepository.java
│   │   │               │
│   │   │               └───infrastructure
│   │   │                   ├───config
│   │   │                   │       ApiKeyInterceptor.java
│   │   │                   │       SecurityConfig.java
│   │   │                   │       SwaggerConfig.java
│   │   │                   │       WebMvcConfig.java
│   │   │                   │
│   │   │                   ├───controller
│   │   │                   │   │   ProductoController.java
│   │   │                   │   │
│   │   │                   │   └───response
│   │   │                   │           JsonApiResponse.java
│   │   │                   │
│   │   │                   ├───exception
│   │   │                   │       GlobalExceptionHandler.java
│   │   │                   │
│   │   │                   └───persistence
│   │   │                       │   JpaProductoRepository.java
│   │   │                       │   SpringDataProductoRepository.java
│   │   │                       │
│   │   │                       ├───entity
│   │   │                       │       ProductoEntity.java
│   │   │                       │
│   │   │                       └───mapper
│   │   │                               ProductoMapper.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───mera
│                   └───productos
│                           ProductosApplicationTests.java
│
└───target
    │   productos-0.0.1-SNAPSHOT.jar
    │   productos-0.0.1-SNAPSHOT.jar.original
    │
    ├───classes
    │   │   application.properties
    │   │
    │   └───com
    │       └───mera
    │           └───productos
    │               │   ProductosApplication.class
    │               │
    │               ├───application
    │               │   │   ActualizarProductoUseCase.class
    │               │   │   CrearProductoUseCase.class
    │               │   │   EliminarProductoUseCase.class
    │               │   │   ListarProductosPaginadosUseCase.class
    │               │   │   ObtenerProductoPorIdUseCase.class
    │               │   │
    │               │   └───dto
    │               │           ActualizarProductoDTO.class
    │               │           CrearProductoDTO.class
    │               │
    │               ├───domain
    │               │   ├───model
    │               │   │       Producto.class
    │               │   │
    │               │   └───port
    │               │           ProductoRepository.class
    │               │
    │               └───infrastructure
    │                   ├───config
    │                   │       ApiKeyInterceptor.class
    │                   │       SecurityConfig.class
    │                   │       SwaggerConfig.class
    │                   │       WebMvcConfig.class
    │                   │
    │                   ├───controller
    │                   │   │   ProductoController.class
    │                   │   │
    │                   │   └───response
    │                   │           JsonApiResponse$DataWrapper.class
    │                   │           JsonApiResponse.class
    │                   │
    │                   ├───exception
    │                   │       GlobalExceptionHandler.class
    │                   │
    │                   └───persistence
    │                       │   JpaProductoRepository.class
    │                       │   SpringDataProductoRepository.class
    │                       │
    │                       ├───entity
    │                       │       ProductoEntity.class
    │                       │
    │                       └───mapper
    │                               ProductoMapper.class
    │
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-archiver
    │       pom.properties
    │
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       │           createdFiles.lst
    │       │           inputFiles.lst
    │       │
    │       └───testCompile
    │           └───default-testCompile
    │                   createdFiles.lst
    │                   inputFiles.lst
    │
    └───test-classes
        └───com
            └───mera
                └───productos
                        ProductosApplicationTests.class
```
---

🧱 Arquitectura y Capas
Este sistema utiliza arquitectura hexagonal (Ports and Adapters) para desacoplar la lógica del negocio de las dependencias externas.
🏛️ Capas del sistema
- Dominio: Contiene la lógica de negocio y las reglas fundamentales.
- Aplicación: Define los casos de uso y orquesta interacciones entre el dominio y la infraestructura.
- Infraestructura: Maneja la persistencia de datos, conectividad y adaptadores.



---

## Diagrama de Interacción entre Servicios (PlantUML)
![interaccion_service](https://github.com/user-attachments/assets/280f2153-65f4-4015-aab2-c4fe32e85532)

---

### Seguridad (API Key)
- Todos los endpoints `/api/productos/**` requieren el header `X-API-KEY` con el valor configurado en `application.properties`.
- El filtro `ApiKeyAuthFilter` valida la presencia y validez de la API Key en cada solicitud.
- Las rutas públicas como Swagger UI y documentación están excluidas del filtro.


---

## Documentación de Endpoints

| Método | Endpoint                | Descripción                        |
|--------|------------------------|------------------------------------|
| PUT    | /api/productos/{id}    | Actualizar un producto existente   |
| DELETE | /api/productos/{id}    | Eliminar un producto               |
| GET    | /api/productos         | Listar todos los productos         |
| GET    | /api/productos/{id}    | Obtener producto por ID            |
| POST   | /api/productos         | Crear un nuevo producto            |


- Todos los endpoints requieren autenticación por API Key.
- Documentación interactiva disponible en: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
---

## Uso de Herramientas de IA en el Desarrollo

Durante el desarrollo de este microservicio se utilizaron herramientas de Inteligencia Artificial para acelerar la generación de código, documentación y pruebas:

- **GitHub Copilot:** Generación de esqueletos de clases, métodos CRUD, anotaciones Swagger y ejemplos de pruebas unitarias/integración.
- **Validación de calidad:** Todo el código generado por IA fue revisado manualmente, adaptado a los estándares del proyecto.

---

## Docker

Para construir y ejecutar el microservicio junto con su base de datos usando Docker Compose:

1. Asegúrate de tener el archivo `docker-compose.yml` en el directorio raíz.
2. Ejecuta:
   ```sh
   docker-compose up --build -d
   ```
   Esto levantará:
   - Una base de datos PostgreSQL para productos (`db_productos`)
   - El microservicio de productos (`producto-service`)

3. Para detener y eliminar los contenedores:
   ```sh
   docker-compose down
   ```

> **Nota:**
> - El microservicio se conectará automáticamente a la base de datos definida en el servicio `test_linktic`.
> - Puedes acceder a la API en [http://localhost:8080](http://localhost:8080) y a la base de datos PostgreSQL en el puerto 5432.
> - Si tienes otros microservicios (como Inventario), puedes agregarlos al mismo archivo `docker-compose.yml` siguiendo la estructura mostrada.
>
---
## Diagrama de base de datos
![diagrama de base de datos](https://github.com/user-attachments/assets/ac5a6610-48b1-4b3a-bb0d-e41bfa17b1ff)


---

---
## Autor
Maria Elizabeth Rodriguez Alejo  
maria.rodriguez@linktic.com


