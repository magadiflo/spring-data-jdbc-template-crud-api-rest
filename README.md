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

````
spring.sql.init.mode=always
````

- Usamos **JdbcTemplate** en nuestra clase de implementación del
  repositorio de **UserRepositoryImpl**.
- Se creó un **CRUD COMPLETO** para el model **User**.

---

## Asociaciones con JDBC

### [Spring Data JDBC – One-to-Many](https://javabydeveloper.com/spring-data-jdbc-one-to-many-example/?amp&fbclid=IwAR2PYU2h8MvB9XfVBt9N0Q7h8gyd7Er4F7Lm75Q1iEJxuKO7aPmUx4n0aCA)
**Fuente**: [javabydeveloper.com](https://javabydeveloper.com/spring-data-jdbc-one-to-many-example/?amp&fbclid=IwAR2PYU2h8MvB9XfVBt9N0Q7h8gyd7Er4F7Lm75Q1iEJxuKO7aPmUx4n0aCA)
- Para mapear la relación **Uno a Muchos**, en la entidad **Customer** tenemos que usar **@MappedCollection** en
  Colección como List or Set or Map.
- La anotación @MappedCollection se utiliza en el proyecto Spring JDBC para mapear una colección de objetos en una tabla
  de base de datos relacional. Esta anotación permite especificar los nombres de columna que se utilizarán para mapear
  los elementos de la colección en la tabla.

````
 /**
   * keyColumn="id", nombre de la clave primaria de la tabla Invoice.
   * idColumn="customer_id", nombre de la clave foránea que hace referencia a la tabla Customer en la tabla Invoice.
   */
@MappedCollection(keyColumn = "id", idColumn = "customer_id")
private Set<Invoice> invoices = new HashSet<>();
````