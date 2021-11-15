# Database e java

Le applicazioni hanno spesso bisogno di recuperare e conservare dati per portare a termine le operazioni a cui sono preposte. 
Nelle sezioni seguenti vediamo cos'è un _database_ e come interagire con esso tramite le _APIs_ messe a disposizione da 
_JDBC_, _JPA_ e _Spring Data JPA_: ogni argomento è approfondito con spiegazioni dettagliate e corredato di esempi pratici.

>Una conoscenza base del linguaggio java è prerequisito per il lettore.

- [Database](dbms/README.md)

Un _Database_ è un software che permette di archiviare dati: nei _Database_ relazionali di cui ci occuperemo, i dati 
sono organizzati in schemi tabellari per semplificare la scrittura, la lettura e la creazione di relazioni.
Per la creazione degli schemi in cui archiviare i dati e per la loro manipolazione viene utilizzato il linguaggio SQL.


- [Java Database Connectivity](jdbc/README.md)

Nella SDK di _java_ sono presenti le _APIs_ che consentono l'interazione con un _database_: in questo spazio vediamo 
come eseguire e recuperare il risultato di una query.

- [JPA](jpa/README.md)

_JPA_ è una specifica che definisce come relazionare oggetti java ai records di un _database_: questo processo, definito
mapping, fa in modo che la lettura o il salvataggio di un oggetto _java_ genera la lettura o l'inserimento di dati 
sul _database. 

# [Spring Data JPA](spring-data-jpa/README.md)

- Setup
- Repository and method naming pattern

