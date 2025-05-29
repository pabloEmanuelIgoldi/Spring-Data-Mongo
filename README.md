#  **Spring Data + Mongo DB (NoSQL)**

# Índice
### Definición del proyecto
### Arquitectura del Proyecto
### Tecnologías y Dependencias
### Spring Data MongoDB
### Ejecución del Proyecto
### Documentación oficial
### Índice de proyectos Spring


# Definición del proyecto

Este proyecto demuestra cómo integrar **Spring Boot** con **Mongo DB** como servidor de base de datos. La caracteristica principal de este gestor de base de datos es que es NoSQL.

# Arquitectura del Proyecto

El proyecto está dividido en las siguientes capas:

- **Controlador**  
  Maneja las peticiones HTTP. Solo opera con objetos DTO.

- **Servicio**  
  Actúa como intermediario entre el controlador y el Repository. Mapea entidades (`Entities`) a DTOs y viceversa.

- **Repository**  
  Interface encargada del acceso y gestión de los datos. Realiza operaciones CRUD sobre la base de datos.

---

# Tecnologías y Dependencias

La aplicación está construida con:

- **Java 17**
- **Spring Boot 3.3.11**
- **Mongo DB**


### Dependencias principales:

| Dependencia                            | Descripción                                     |
|----------------------------------------|-------------------------------------------------|
| `spring-boot-starter-web`              | Construcción de aplicaciones web                |
| `spring-boot-starter-validation`       | Validación de datos                             |
| `lombok`                               | Reducción de código repetitivo con anotaciones  |
| `springdoc-openapi-starter-webmvc-ui`  | Documentación y pruebas de API (Swagger)        |
| `spring-boot-starter-data-mongodb`     | Funcionalidad  para trabajar con MongoDB        |

---

# Spring Data MongoDB

Proporciona toda la funcionalidad necesaria para trabajar con MongoDB a través de la dependencia **spring-boot-starter-data-mongodb** que esta incluida en el POM.

## Base de datos NoSQL

Las bases de datos NoSQL no tienen relacionales entre tablas ni esquema rigido de tablas con filas y columnas. 

Los tipos de bases de datos NoSQL son: clave-valor, documentos, graficos, etc.

## MongoDB

Es una base de datos NoSQL (no relacional) de código abierto, diseñada para almacenar y gestionar grandes volúmenes de datos de manera flexible y escalable.
MongoDB utiliza un modelo de datos basado en **documentos**.

El formato del documento es **BSON**. Es un formato en binario y tiene una estructura similar a JSON.

Cada registro es un documento dentro de una **colección** (equivalente a una tabla en SQL).

## Caso de uso de MongoDB
Un microservicio implementado en Spring Boot debe considerar el uso de MongoDB cuando:
- Estructura cambiante (schemas flexibles).
- Se requiere escalabilidad horizontal y alta disponibilidad.
- Los datos son no estructurados o semi-estructurados .
- Se busca reducir la complejidad de joins y normalización.
- Se trabaja con documentos o estructuras similares a JSON.
- Alto volumen de lecturas/escrituras (rendimiento en operaciones simples).
- Datos jerárquicos o anidados (ej: comentarios con respuestas).

## Cuándo NO usar MongoDB
- Transacciones complejas (ej: bancos, sistemas contables).
- Relaciones fuertes entre datos (ej: facturas con clientes y productos).
- Consultas analíticas complejas (JOINs, agregaciones avanzadas).
- Requisitos ACID estrictos (aunque MongoDB tiene transacciones, no es su fuerte).

## Conclusión
MongoDB es ideal para proyectos que requieren flexibilidad, escalabilidad y manejo de datos no estructurados. Aunque no es la mejor opción para transacciones complejas con relaciones estrictas (donde una base de datos SQL sería más adecuada).

## Visualizador(GUI)
Cliente oficial de Mongo para visualizar la base de datos:

	https://www.mongodb.com/try/download/compass


---
# Ejecución del Proyecto

### Requisitos:

- Java 17
- Docker (para Mongo DB, opcional)
- IDE o herramienta de compilación (IntelliJ, Maven, etc.)

### Pasos:

1. Clona el repositorio.
2. Configura las propiedades en `application.properties` con los parametros de tu base de datos.
3. Levanta Mongo DB (puedes usar Docker).
4. Levanta la aplicación.
5. Usa Swagger para probar la aplicación.

### Servicio: Mongo DB
Si no tienes el motor de base de datos Mongo DB se puede levantar con el siguiente 
`docker-compose.yml` ejecutandolo en docker:

```yaml
version: '3.8'

services:
  mongodb:
    image: mongo:latest
    container_name: mongodb
    ports:
      - "27017:27017"
    volumes:
      - mongodb_data:/data/db
    environment:
      - MONGO_INITDB_ROOT_USERNAME=admin
      - MONGO_INITDB_ROOT_PASSWORD=pass1234
      - MONGO_INITDB_DATABASE=apiMongoDB
    networks:
      - mongo-network

volumes:
  mongodb_data:

networks:
  mongo-network:
    driver: bridge
```


### SWAGGER

Para probar la API se puede ingresar a:

http://localhost:8080/api-mongo/swagger-ui/index.html

http://localhost:8080/api-mongo-docs


---
#  **Documentación oficial**

https://docs.spring.io/spring-data/mongodb/reference/

https://spring.io/guides/gs/accessing-mongodb-data-rest

https://www.mongodb.com/resources/products/compatibilities/spring-boot
  
---
#  **Índice de proyectos Spring**
##  **Proyectos Spring Boot**
- [Response Uniforme](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Response-Wrapper)
- [LogBack](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Logback)
- [Profile](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Profile)
- [Spring Doc](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Swagger)
- [Validate](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Validate)
- [Inter-Service Communication](https://github.com/pabloEmanuelIgoldi/Spring-Boot-Inter-Service-Communication)
##  **Proyectos Spring Data**
- [Spring Data + Redis(Cache)](https://github.com/pabloEmanuelIgoldi/Spring-Data-Redis)
- [Spring Data + Mongo DB (NoSQL)](https://github.com/pabloEmanuelIgoldi/Spring-Data-Mongo)
- [Spring Data + ElaticSearch](https://github.com/pabloEmanuelIgoldi/Spring-Data-Elasticsearch)
 
