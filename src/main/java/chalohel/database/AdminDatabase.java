package chalohel.database;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AdminDatabase {

    protected SessionFactory sessionFactory;

    public void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
        try {
            sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }

    public void creatDatabase(String nameDastabase) {

        var sqlScript = "CREATE DATABASE IF NOT EXISTS " +
            nameDastabase.concat("db ;") ;

        var s = sessionFactory.openSession();
        var tx = s.beginTransaction();
        s.createNativeQuery(sqlScript).executeUpdate();
        tx.commit();
        s.close();
    }

    public void dropDatabase(String nameDastabase) {

        var sqlScript = "DROP DATABASE IF EXISTS " +
            nameDastabase.concat("db ;") ;

        var s = sessionFactory.openSession();
        var tx = s.beginTransaction();
        s.createNativeQuery(sqlScript).executeUpdate();
        tx.commit();
        s.close();
    }

    public void grantAll(String name) {


        String sqlScript = "" + name+
            "GRANT ALL PRIVILEGES ON mikdb.* TO mik@localhost;" ;

        var s = sessionFactory.openSession();
        var tx = s.beginTransaction();
        s.createNativeQuery(sqlScript).executeUpdate();
        tx.commit();
        s.close();
    }

    public void creatPass(String name, String password) {
        var sqlScript =
            "SET PASSWORD FOR " +
                name.concat("@localhost") +
                " = PASSWORD('" + password + "'); ";

        var s = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.createNativeQuery(sqlScript).executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

    public void creatUser(String nameUser) {
        var sqlScript = "CREATE USER IF NOT EXISTS " +
            nameUser + "@localhost ;";

        var s = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.createNativeQuery(sqlScript).executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}
