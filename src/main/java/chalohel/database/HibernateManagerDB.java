package chalohel.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateManagerDB implements IDatabaseManager {

    private static SessionFactory sessionFactory;
    HibernateUtil manager;
    private Session session;

    public HibernateManagerDB() {
        manager = new HibernateUtil();
    }

    @Override
    public void createUser(String name, String password) {
        String query =
            " CREATE USER " + name + "@127.0.0.1 " +
                "IDENTIFIED BY '" + password + "'";
        gerRQ(query);
    }

    @Override
    public void setGrantUser() {
        String query =
            "GRANT ALL PRIVILEGES ON *.*" +
                "TO 'newuser'@'localhost'";
        gerRQ(query);
    }

    @Override
    public void createDB() {
        String query = "String name, String password";
        gerRQ(query);
    }

    @Override
    public void createTable() {
        String query = "String name, String password";
        gerRQ(query);
    }

    private void gerRQ(String query) {
        manager.startSession();
        manager.getResultQuery(query);
        manager.endSession();
    }

}
