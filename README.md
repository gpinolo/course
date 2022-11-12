# Database e java

Le applicazioni hanno spesso bisogno di recuperare e conservare dati per portare a termine le operazioni a cui sono preposte:
l'insieme di queste informazioni viene archiviato in un sistema informatico denominato _database_.
Nelle sezioni seguenti vediamo come interagire con esso tramite il linguaggio _SQL_ e le _APIs_ (Application Programming Interface) 
messe a disposizione da _JDBC_, _JPA_ e _Spring Data JPA_: ogni argomento è approfondito con spiegazioni dettagliate e corredato di esempi pratici.

>Una conoscenza base del linguaggio java è prerequisito per il lettore.

- [Database](dbms/README.md)

Un _database_ è un software per l'archiviazione di dati: vediamo come creare una struttura e come manipolare i dati
utilizzando il linguaggio _SQL_. 


- [Java Database Connectivity](jdbc/README.md)

Esploriamo le _APIs_ che _java_ mette a disposizione per interagire con un _database_ e come utilizzarle per eseguire 
e recuperare il risultato di una query.

- [JPA](jpa/README.md)

Analizziamo _JPA_ e come esso ci consente di relazionare oggetti di un'applicazione _java_ con struttura dati di un 
_database_ e persistere le operazioni eseguite su tali oggetti sul _database_. 

- [Spring Data JPA](spring-data-jpa/README.md)

Vediamo come _Spring Data JPA_ semplifica la scrittura del codice per l'accesso ai dati in un'applicazione _java_ 
che utilizza JPA.
