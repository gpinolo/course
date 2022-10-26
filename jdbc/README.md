# Java Database Connectivity (JDBC)

_JDBC_ è costituito da una serie di _APIs_ presenti nel package _java.sql_ che permette ad un programma java di connettersi ad un _database_ 
per inerrogare e modificare i dati in esso presenti.

# Obtain database connection

Il primo step per poter eseguire operazioni su un _database_ è connettersi ad esso attraverso la classe [_java.sql.DriverManager_](https://docs.oracle.com/javase/8/docs/api/java/sql/DriverManager.html) 
come riportato nel seguente snippet di codice:

~~~java
...
import java.sql.Connection;
import java.sql.DriverManager;
...

public class DBConnectionExample {
 
  public void connect(){
      try (Connection connection = DriverManager.getConnection (dbUrl, user,pwd)){
          ...
      }
      catch (SQLException sqlException) {
          ...
      }
  }
}
~~~

Da notare che la connessione viene acquisita all'interno di un costrutto [_try with Resources_](https://www.baeldung.com/java-try-with-resources) per assicurarsi che la connessione venga chiusa al termine dell'esecuzione.

# Query execution

Una volta ottenuta la connessione, l'esecuzione di operazioni su un _database_ avviene attraverso una delle implementazioni della classe [_java.sql.Statement_](https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html)
come riportato nel seguente snippet di codice:

~~~java

...
import java.sql.Connection;
import java.sql.Statement;
...

public class QueyExecutionExample {
 
  public void queryExecution(Connection connection){
      String sql = "SELECT * FROM student";
      try (Statement statement = connection.createStatement()){
          statement.executeQuery(sql);
          ...
      }
      catch (SQLException sqlException) {
          ...
      }
  }
}
~~~

Anche in questo caso lo statement viene chiuso al termine dell'operazione grazie al costrutto _try with Resources_.

# Processing result

Il risultato un'operazione eseguita sul _database_ varia a seconda del tipo; quello di una creazione, un aggiornamento o una cancellazione ritorna 
il numero di dati creati, aggiornati o cancellati:

~~~java

...
import java.sql.Statement;
...

public class ProcessingCreationExample {
 
  public void processing(Statement statement){
      try{
          int insertedRow = statement.executeUpdate("INSERT INTO student (id, name) VALUES (1, \"JHON\")");
          ...
      }
      catch (SQLException sqlException) {
          ...
      }
  }
}
~~~

La lettura di dati ritornerà un [_java.sql.ResultSet_](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html) contenente i dati del database che rispettano le condizioni presenti nella query:

~~~java

...
import java.sql.Statement;
import java.sql.ResultSet;
...

public class ProcessingReadExample {
 
  public void queryExecution(Statement statement){
      try{
          ResultSet resultSet = statement.executeQuery("SELECT id, name FROM student");
          while (resultSet.next()){
              resultSet.getInt("id");
              resultSet.getString("name");
          }
          ...
      }
      catch (SQLException sqlException) {
          ...
      }
  }
}
~~~
