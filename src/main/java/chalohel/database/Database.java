package org.chalohel.database;

import java.sql.*;

/**
 * The type Database.
 */
public class Database {

  private final Connection connessione;
  private final Configuration configurazione;
  private Statement statement;
  private String url;

  /**
   * Instantiates a new Database.
   *
   * @param conf configurazione
   *
   * @throws SQLException the sql exception
   */
  public Database ( Configuration conf ) throws SQLException {
    this.configurazione = conf;
    url = setUrl(configurazione);
    connessione = newConnection();
  }

  /**
   * Sets url.
   *
   * @param conf configurazione della connessione
   *
   * @return url per la connessione
   */
  public String setUrl ( Configuration conf ) {
    url = "jdbc:" +
      conf.getConfigProps().getProperty("DB") + "://" +
      conf.getConfigProps().getProperty("host") + ":" +
      conf.getConfigProps().getProperty("port") + "/" +
      conf.getConfigProps().getProperty("nameDB");
    return url;
  }


  /**
   * Crea una nuova connessione al DB Utilizza la configurazione esterna
   *
   * @param url      url del DB
   * @param username nome utente del DB
   * @param password password del nome utente
   *
   * @return connessione stabilita con successo
   *
   * @throws SQLException kk
   */
  public Connection newConnection(String url, String username, String password)
      throws SQLException {
    System.out.println("URL = " + url);
    return DriverManager.getConnection(url, username, password);
  }

  /**
   * Utilizza la configurazione interna
   *
   * @return connessiona stabilita con successo
   *
   * @throws SQLException kk
   */
  public Connection newConnection () throws SQLException {
    setUrl(configurazione);
    return newConnection(url,
      configurazione.getConfigProps().getProperty("user"),
      configurazione.getConfigProps().getProperty("password"));
  }

  /**
   * Crea un nuovo Statment da usare per le query
   *
   * @param conn Connessione creata
   *
   * @return uno statement attivo
   *
   * @throws SQLException kk
   */
  public Statement newStatement ( Connection conn ) throws SQLException {
    statement = conn.createStatement();
    return statement;
  }


  /**
   * Gets select.
   *
   * @param query g
   *
   * @return dfg select
   *
   * @throws SQLException fds
   */
  public ResultSet getSelect( String query) throws SQLException {
    var conn = newConnection();
    statement = conn.createStatement();
    ResultSet rs = statement.executeQuery(query);
    conn.close();
    return rs;
  }


  /**
   * Print class.
   */
  public void printClass(){
    System.out.println(this);
  }

  @Override
  public String toString () {
    return "Database{" +
      "connessione=" + connessione +
      ", configurazione=" + configurazione.toString() +
      ", statement=" + statement +
      ", url='" + url + '\'' +
      '}';
  }

}