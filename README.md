# [Data Base Management System](dbms/README.md)

Un _Data Base Management System_ (DBMS) è un sistema software per la creazione, la manipolazione e l'interrogazione di dati.


# [Java Data Base Connection](jdbc/README.md)
- Obtain data base connection
- Statement execution
- Processing ResultSet

# [JPA](jpa/README.md)

- Entity
	- @Entity, @Table, @Column annotations
- EntityManager
- Relationship
	- One to One
	- One to Many
	- Many to Many
- Cascade and Fetch Strategy
- Validation
- JPQL/Named Query/Criteria API/Native Query
- Transaction
- JPA providers (Hibernate)

https://www.baeldung.com/tag/jpa/

# [Spring data JPA](spring-data-jpa/README.md)

- Setup
- Repository and method naming pattern


- H2 
    - Setup
    - Schema creation with DDL and CRUD operation with DML exercise

<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>1.4.200</version>
    <scope>test</scope>
</dependency>

java -jar h2-1.4.200.jar -webAllowOthers -tcpAllowOthers



