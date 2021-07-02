package chalohel.database;

import chalohel.database.entity.Credential;
import chalohel.database.entity.PasswordManager;
import chalohel.database.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * The type Hibernate util.
 */
public class HibernateUtil implements IORM {
    // static Logger log = Logger.getLogger(App.class);

    private SessionFactory sessionFactory;
    private Session session;

    public HibernateUtil() {
        setup();
        this.sessionFactory = this.getSessionFactory();
    }

    public void setup() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        getSessionFactory().close();
    }

    /**
     * Start session.
     */

    public void startSession() {
        session = getSessionFactory().openSession();
        session.beginTransaction();
    }

    /**
     * End session.
     */
    public void endSession() {
        session.getTransaction().commit();
        session.close();
    }


    public void create(String name, String pass) {


        startSession();
        User user = new User(name);
        byte[] salt = PasswordManager.getNextSalt();
        byte[] passw = PasswordManager.hash(pass.toCharArray(), salt);

        Credential cre = new Credential(passw, salt);


        cre.setUser(user);
        user.setCredential(cre);

        session.persist(user);

        session.getTransaction().commit();
        session.close();

    }


    @Override
    public void create() {

    }

    @Override
    public void select(Long id) {
        startSession();

         /*
    User user = session.get(User.class, bookId);
    Credential cre = session.get(Credential.class, bookId);

    System.out.println("Nome:     " + user.getName());
    System.out.println("Ruolo:    " + user.getRole());
*/
        endSession();
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void drop(Long id) {

    }


    public void update() {
        User book = new User("");

        startSession();

        session.update(book);

        endSession();
    }

    public void drop() {
        User book = new User("");
        startSession();
        session.delete(book);
        endSession();
    }


    /**
     * Restituisce l'ID dell' utente
     * con il nominativo passato.
     *
     * @param name nome utente.
     * @return ID dell' utente se è stato trovato. 0 altrimenti.
     */
    public long getID(String name) {

        startSession();
        List<User> users = getResultQuery("FROM User WHERE name='" + name + "'");
        endSession();

        if (!users.isEmpty()) {
            return users.get(0).getId();
        }// TODO MY EXCEPTION
        return 0;
    }

    /**
     * @param id
     * @return
     */
    public byte[] getPassword(long id) {
        byte[] result;
        startSession();
        List<Credential> cred = getResultQuery("FROM Credential WHERE id='" + id + "'");
        if (cred.size() == 1) {
            result = cred.get(0).getPassword();
        }// TODO MY EXCEPTION
        result = null;

        endSession();

        return result;
    }

    /**
     * @param id id
     * @return salt
     */
    public byte[] getSalt(long id) {
        byte[] result;
        startSession();
        List<Credential> cred;
        cred = getResultQuery("FROM Credential WHERE id='" + id + "'");
        // TODO MY EXCEPTION
        if (cred.size() == 1) result = cred.get(0).getSalt();
        result = null;

        endSession();

        return result;
    }

    public boolean check(String name, String pass) {

        boolean check = false;
        startSession();

        long id = getID(name);
        if (id != 0) {

            //  log.info("Genera salt");
            byte[] salt = PasswordManager.getNextSalt();

            //    log.info("Avvio Setup");
            Credential c1 = new Credential(pass.getBytes(), salt);
        }
        return check;
    }

    public List getResultQuery(String query) {
        startSession();

        Query que = session.createQuery(query);

        return que.list();
    }
}