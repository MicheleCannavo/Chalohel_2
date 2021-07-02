package chalohel.database;

public interface IDatabaseManager {

    void createUser(String name, String password);

    void setGrantUser();

    void createDB();

    void createTable();

}
