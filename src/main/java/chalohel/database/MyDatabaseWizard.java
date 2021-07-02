package chalohel.database;

import chalohel.database.entity.Credential;
import chalohel.database.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class MyDatabaseWizard {

  //  SchemaExport schemaExportx = new SchemaExport();

    public static void main(String[] args) {
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        settings.put("hibernate.connection.url",
            "jdbc:mysql://127.0.0.1:3306/mikdb");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.connection.username", "mik");
        settings.put("hibernate.connection.password", "mik");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");


        ServiceRegistry serviceRegistry =
            new StandardServiceRegistryBuilder()
                .applySettings(settings)
                .build();

        MetadataSources metadata =
            new MetadataSources(serviceRegistry);
        metadata.addAnnotatedClass(User.class);
        metadata.addAnnotatedClass(Credential.class);

        EnumSet<TargetType> enumSet = EnumSet.of(TargetType.DATABASE);
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.execute(enumSet, SchemaExport.Action.BOTH, metadata.buildMetadata());

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        sessionFactory.getCurrentSession();


    }
}
