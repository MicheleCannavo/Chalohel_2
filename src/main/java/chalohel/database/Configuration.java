package chalohel.database;

import java.util.Properties;

/**
 * Questa classe permette la gestione di varie configurazioni.
 * E' presente una di default ma sempre cambiare Si possono
 * avere più configurazioni. Legge la Configuration da YAML.
 *
 * @author    Cannavo' Michele
 * @version   0.8.0
 */
public class Configuration {

  private final Properties configProps = new Properties();
  private String nameConfig            = "config";
  private String pathConfigurazione;

  /**
   * Permette la creazione di un istanza con uno specifico nome
   *
   * @param nameConfig nome della Configuration
   */
  public Configuration ( String nameConfig ) {
    this.nameConfig = nameConfig;
    defaultConfig();
    configProps.setProperty("nameDB", nameConfig);
  }

  public void defaultConfig () {
    configProps.setProperty("drive", "jdbc");
    configProps.setProperty("DB", "mysql");
    configProps.setProperty("host", "localhost");
    configProps.setProperty("port", "3306");
    configProps.setProperty("user", "root");
    configProps.setProperty("password", "root");
    configProps.setProperty("nameDB", "prova1");
    configProps.setProperty("driver", "com.mysql.cj.jdbc.Driver");
  }

  /**
   * TODO implementare
   */
  public void loadFromFile () {
    // Carica una Configuration da un file YAML
  }

  /**
   * Gets name config.
   *
   * @return Nome configurazione
   */
  public String getNameConfig () {
    return nameConfig;
  }

  /**
   * Sets name config.
   *
   * @param nameConfig nome della configurazione
   */
  public void setNameConfig ( String nameConfig ) {
    this.nameConfig = nameConfig;
  }

  /**
   * Gets config props.
   *
   * @return La configurazione dell' istanza
   */
  public Properties getConfigProps() {
    return configProps;
  }

  /**
   * Print config.
   */
  public void printConfig () {
    System.out.println(this);
  }

  @Override
  public String toString () {
    return
      "Configuration "  + this.nameConfig + "{" + System.lineSeparator() +
      "\thost       = " + this.configProps.getProperty("host") + System.lineSeparator() +
      "\tport       = " + this.configProps.getProperty("port") + System.lineSeparator() +
      "\tuser       = " + this.configProps.getProperty("user") + System.lineSeparator() +
      "\tpassword   = " + this.configProps.getProperty("password") + System.lineSeparator() +
      "\tnameDB     = " + this.configProps.getProperty("nameDB") + System.lineSeparator() +
      "\tdriver     = " + this.configProps.getProperty("driver") + System.lineSeparator() +
      "}" + System.lineSeparator() ;
  }
}