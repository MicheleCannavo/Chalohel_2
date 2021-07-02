package chalohel.menu.action;

import chalohel.database.HibernateUtil;
import chalohel.utility.console.Console;
import chalohel.utility.console.Output;
import chalohel.utility.validator.ValidateName;
import chalohel.utility.validator.ValidatePassword;

/**
 * The type Registrazione.
 */
public class Registrazione implements Iaction {
  @Override
  public void run() {
   HibernateUtil manager = new HibernateUtil();

    String username = requiredName();
    //   log.info("Inserito nome utente: " + username);

    String password = requiredPassword();
    //   log.info("Inserita password: " + password);

    manager.create(username, password);
  }

  @Override
  public String getNameAction() {
    return null;
  }

  /**
   * The constant action.
   *
   * @return the name action
   *
  public static String getNameAction() {
    return "Registrazione";
  }

  /**
   * Run.
   *
   * @param tentativi the tentativi
   *
  public void run(int tentativi) {
    var username = "";
    String email = "";
    String password = null;
    String repeatpassword = null;

    username = requiredName();
    email = requiredEmail();
    password = requiredPassword();
  }




  private String requiredName() {
    var request = "";
    var isOk = false;

    while(! isOk) {
      request = Validator.request();

      if(QueryBuild.nameIsPresent(request)) {
        isOk = true;
      } else {
        Console.printnlLine("Nick già presente - Sceglierne uno nuovo");
      }
    }
    return request;
  }

  private String requiredEmail() {
    var email = "";
    var isOk = false;

    while(! isOk) {
      email = Validator.request();

      if(QueryBuild.emailIsPresent(email)) {
        isOk = true;
      } else {
        Console.printnlLine("Email già presente - Sceglierne una nuova");
      }
    }
    return email;
  }

  private String requiredPassword() {
    var password = "";
    var repeatPassword = "";
    var isOk = false;

    while(true) {

      Console.printLine(ValidatePassword.getDescriptorRulesValidation());
     // password = ValidatePassword.request();

      Console.printLine(ValidatePassword.getDescriptorRulesValidation());
     // repeatPassword = ValidatePassword.request();

      if(! password.equals(repeatPassword)) {
        Console.printLine("Le password non corrispondono");
      } else {
        return password;
      }
    }
  }
*/


  /**
   *
   * @return name
   */
  private static String requiredName() {
    HibernateUtil manager = new HibernateUtil();
    String request = ValidateName.getInstance().request();
    Output.printnlLine(request);
    while (manager.getID(request) != 0) {
      Console.clrscr();
      Output.printIsPresent("name");
      request = ValidateName.getInstance().request();
    }
    return request;
  }


  /**
   * @return password
   */
  private static String requiredPassword() {
    String password = ValidatePassword.getInstance().request();
    String repeatPassword = ValidatePassword.getInstance().request();

    while (!password.equals(repeatPassword)) {
      Console.clrscr();
      Output.printLine("Le password non corrispondono");
      password = ValidatePassword.getInstance().request();
      repeatPassword = ValidatePassword.getInstance().request();
    }
    return password;
  }


}
