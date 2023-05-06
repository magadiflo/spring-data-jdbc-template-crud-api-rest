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

### [Spring Data JDBC – One-to-One](https://javabydeveloper.com/spring-data-jdbc-one-to-one-example/?amp)

- Trabajamos con las entidades **Customer** y **Address**, donde **Customer** es la entidad raíz.
- En la entidad **Customer** Agregamos el atributo **Address**, para mapear la
  asociación necesitamos agregar la anotación **@Column** especificando en su interior
  la Foreing Key de la tabla Customer.

````
/**
 * OneToOne [Customer 1 -- 1 Address]
 * **********************************
 * customer_id, corresponde al nombre de la columna (fokeing key)
 * en la tabla addresses
 */
@Column(value = "customer_id")
private Address address;
````

- Spring Data se inspira en los conceptos **Aggregate, Aggregate Root y Repository** de
  Domain Driven Design.
- **Aggregate**: Es un conjunto de entidades de dominio (Order, OrderLine, Post, Comment)
  que **están estrechamente relacionadas entre sí y forman un todo, un único conjunto**. Por
  ejemplo, un post puede tener varios comentarios. Un comentario no puede existir sin tener
  asociado un post.
- **Aggregate root**: Cada agregado que se define tiene una entidad raíz de la que colgarán
  el resto de entidades. Es importante destacar que una entidad raíz no tiene otra entidad
  de la que dependa, si no que es la raíz de todas las demás entidades. En nuestro ejemplo,
  tenemos la entidad **Customer** como entidad raíz de la que dependen **Invoice, Address**.
- **Repository**: un repositorio trabaja con el Aggregate Root para obtener los agregados.
  Si una entidad que forma parte de un agregado se tiene que persistir en la base de datos
  se hará a través del Aggregate Root usando el repositorio de esa entidad raíz para realizar
  la operación.