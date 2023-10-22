# Crud API REST Con Spring Data JDBC Template y Asociaciones con JDBC

## Crud API REST Con Spring Data JDBC Template

El proyecto está elaborado basado en las siguientes fuentes:

- [Java Guides - Crud API REST Con JDBC y Spring Boot - Tomado de JavaGuides y Knowledge Factory](https://www.javaguides.net/2019/08/spring-boot-spring-jdbc-mysql-crud-example.html)
- [Knowledge Factory - Build REST CRUD APIs with Spring Boot and Spring Data JDBC](https://www.knowledgefactory.net/2022/02/build-rest-crud-apis-with-spring-boot-spring-data-jdbc.html)

### Configurando el application.properties

- La inicialización basada en scripts, es decir, insertar datos a través de **data.sql**
  o crear un esquema a través de un **schema.sql**, solo se realiza de forma predeterminada
  cuando se utiliza una base de datos integrada en memoria (como h2).
- En nuestro caso, como usamos MySQL como base de datos externa, si queremos que se ejecuten
  nuestros scripts **(schema.sql y data.sql)**, debemos agregar la siguiente configuración:

````properties
spring.sql.init.mode=always
````

- Usamos **JdbcTemplate** en nuestra clase de implementación del
  repositorio de **UserRepositoryImpl**.
- Se creó un **CRUD COMPLETO** para el model **User**.

