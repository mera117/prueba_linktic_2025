🧩 Microservicio de Productos

Este microservicio está desarrollado con Spring Boot 3 y estructurado bajo principios de arquitectura limpia. Se encarga de la gestión de productos mediante un conjunto de endpoints RESTful que permiten crear, consultar, actualizar y eliminar entidades de producto. Utiliza Spring Data JPA para el acceso a datos sobre una base de datos PostgreSQL, asegurando persistencia eficiente y desacoplada.
La seguridad está implementada mediante un filtro personalizado que verifica una API Key en las cabeceras HTTP, restringiendo el acceso a los recursos protegidos. La documentación de la API se genera automáticamente usando SpringDoc OpenAPI 3, permitiendo la exploración interactiva desde Swagger UI. Está preparado para entornos de contenedores mediante Docker y docker-compose, y cuenta con pruebas unitarias y de integración.

📦 Microservicio de Inventario

El microservicio de inventario está desarrollado en Spring Boot 3 y aplica una arquitectura hexagonal (ports and adapters) para desacoplar la lógica del dominio de las tecnologías externas. Este servicio se encarga del manejo del stock de productos: consultar cantidades disponibles, registrar ingresos y egresos, y actualizar el inventario en función de las operaciones de compra o entrada.
Los productos se consultan a través de integración REST con el Microservicio de Productos, y las operaciones de stock se exponen como endpoints REST protegidos mediante JWT (JSON Web Token), validado por un filtro de autenticación personalizado. El servicio está instrumentado para generar logs estructurados, validaciones centralizadas, y también expone su documentación vía Swagger UI. Preparado para despliegue mediante Docker, incluye pruebas unitarias y de integración.

💻 Frontend Angular

El cliente web está desarrollado con Angular 20 utilizando una arquitectura moderna basada en standalone components, zoneless change detection (sin NgZone) y SSR-ready (Server-Side Rendering). Consume los endpoints expuestos por los microservicios de Productos e Inventario, permitiendo a los usuarios finales realizar operaciones de gestión y visualización de inventario en tiempo real.
El proyecto está estructurado modularmente y utiliza RxJS y HttpClient para la comunicación asíncrona con los servicios. La seguridad se maneja mediante inyección del JWT en los headers HTTP para proteger las rutas privadas, integrando un HttpInterceptor. Además, se proporciona una interfaz amigable, responsiva y desacoplada del backend, preparada para despliegue en contenedores Docker.---

---

## Descripción General
Microservicio desarrollado con Spring Boot 3, orientado a la gestión de productos a través de una API RESTful. Permite realizar operaciones CRUD sobre productos, persistiendo los datos en una base de datos PostgreSQL mediante Spring Data JPA.
La autenticación está implementada mediante un esquema de API Key, verificada a través de un filtro HTTP personalizado. Este servicio se comunica con otros microservicios utilizando Spring WebClient, facilitando una integración asíncrona, desacoplada y reactiva.
La documentación de los endpoints se genera automáticamente mediante SpringDoc OpenAPI 3, accesible vía Swagger UI para facilitar la exploración y pruebas. Está dockerizado y preparado para entornos de despliegue local o en la nube, e incluye pruebas automatizadas con JUnit y Mockito.
---

## Tecnologías Utilizadas
- Java 23
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Spring Security (API Key)
- Swagger/OpenAPI (springdoc-openapi)
- JUnit y Mockito
- Docker
- Angular 17

---

## Requisitos Previos
- Java 17 o superior
- Maven 3.9.x
- PostgreSQL
- Docker (opcional, para despliegue)

---

## Instalación
1. Clona el repositorio:
   ```sh
   git clone <URL-del-repositorio>
   cd producto-service
   ```
2. Compila el proyecto:
   ```sh
   ./mvnw clean package
   ```

---

## Configuración
Edita el archivo `src/main/resources/application.properties` para configurar la conexión a la base de datos y la API Key:

```properties
spring.datasource.url= jdbc:postgresql://postgres-db:5432/test_linktic
spring.datasource.username=postgres
spring.datasource.password=tu_password
service.api.key=tu_api_key
```

---

## Ejecución
Ejecuta la aplicación localmente:
```sh
java -jar target/Productos-0.0.1-SNAPSHOT.jar
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

---

---

## Arquitectura y Capas

Se realiza el uso de la arquitectura hexagonal (también conocida como Ports and Adapters) es un patrón que busca separar claramente el núcleo de la lógica del negocio de
las dependencias externas (como bases de datos, interfaces web, APIs, etc.), logrando así un sistema más mantenible, testable y desacoplado.

🔶 1. Dominio (Núcleo o Core)
Es el corazón del sistema. Contiene la lógica de negocio pura y es completamente independiente de frameworks, bases de datos o librerías externas.

Incluye:
Entidades: Modelos del dominio con comportamiento. Ej.: Producto, Inventario.

Value Objects: Objetos inmutables que representan conceptos con valor (como Precio, Cantidad).

Servicios de Dominio: Contienen lógica de negocio que no pertenece a una sola entidad.

Interfaces de Puertos (Ports): Interfaces que definen los contratos que necesita el dominio para funcionar.

✅ No debe conocer nada de infraestructura externa.

🔷 2. Puertos (Ports)
Son interfaces que definen cómo interactuar con el núcleo desde el exterior o cómo el núcleo interactúa hacia el exterior. Se clasifican en:

Puertos de Entrada (Driving Ports): Representan casos de uso que otros componentes pueden ejecutar. Ej.: InventarioService.agregarProducto().

Puertos de Salida (Driven Ports): Representan dependencias externas que el núcleo necesita, pero que no implementa directamente. Ej.: RepositorioProducto, NotificadorDeEventos.

✅ Se definen dentro del dominio para no depender de implementaciones externas.

🟩 3. Adaptadores (Adapters)
Son las implementaciones concretas de los puertos. Se ubican en los bordes del sistema.

Tipos:
Adaptadores de Entrada: Transforman entradas externas (HTTP, CLI, mensajería) en comandos del dominio.

Ej.: Controladores REST, GraphQL, endpoints Kafka.

Adaptadores de Salida: Implementan la lógica de conexión con tecnologías externas.

Ej.: Repositorios JPA, clientes HTTP, integraciones con otros sistemas.

✅ Son reemplazables sin afectar el dominio.

🔁 4. Casos de Uso (Application Layer)
En implementaciones más detalladas, se incluye una capa de aplicación entre los adaptadores y el dominio puro.

Coordina entidades y servicios del dominio.

Se comunica con los puertos de entrada y salida.

No contiene lógica de negocio, pero sí orquestación.

🧱 5. Infraestructura
Es donde viven los detalles técnicos y configuraciones:

Spring Boot, frameworks, JPA, API REST, Kafka, bases de datos, etc.

Implementa los adaptadores de salida.

✅ Nunca toca directamente el dominio.


🎯 Diagrama Simplificado
         ┌──────────────────────────┐
         │   Adaptador de Entrada   │  ← REST, CLI, Web
         └────────────┬─────────────┘
                      ↓
               ┌────────────┐
               │   Puerto   │ ← Interfaz de entrada
               │ de Entrada │
               └────────────┘
                      ↓
             ┌────────────────┐
             │     CASO DE    │ ← Lógica de aplicación
             │     USO        │
             └────────────────┘
                      ↓
         ┌────────────┴─────────────┐
         │         Dominio          │ ← Entidades, servicios, reglas
         └────────────┬─────────────┘
                      ↓
             ┌────────────┐
             │   Puerto   │ ← Interfaz de salida
             │ de Salida  │
             └────────────┘
                      ↓
         ┌──────────────────────────┐
         │   Adaptador de Salida    │  ← JPA, HTTP client, etc.
         └──────────────────────────┘


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


