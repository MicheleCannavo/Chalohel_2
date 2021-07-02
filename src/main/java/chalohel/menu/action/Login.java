package chalohel.menu.action;


/**
 * The type Login.
 */
public class Login implements Iaction {

  @Override
  public void run() {

  }

  /**
   * The constant action.
   *
   * @return the name action
   */
  @Override
  public String getNameAction() {
    return "Login";
  }


  /**
   * Run.
   *

  public void run() {

    var username = Input.readLine("Nome utente: ");
    var password = Input.readPassword();
    var manager = new HibernateUtil();

    manager.read();

    List<User> users = manager.getResultQuery("FROM User WHERE name='" + username + "'");
    List<Credential> credential;
    String passwordCredential = "";
    byte[] saltCredential     = null;

    // users.size() == 0 --> Nessun Utente
    // users.size() == 1 --> UTENTE tROVATO IN UTENTI
    // users.size() > 1  --> database con duplicazioni di nomi
    if(users.size() == 1) {
      credential = manager.getResultQuery("FROM Credential where id='" + users.get(0).getId() + "'");
      passwordCredential = credential.get(0).getPassword();
      saltCredential     = credential.get(0).getSalt();

      Console.printLine(passwordCredential+"        "+saltCredential);

      if(passwordCredential.equals(password)) {
        Menu2.initialize();
        Menu2.printMenu();

      }


    }
  }/**/
}