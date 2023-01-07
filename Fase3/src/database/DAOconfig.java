package database;

public class DAOconfig {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root"; 
    private static final String DATABASE = "DSS_Project";
    private static final String DRIVER = "jdbc:mysql";
    static final String URL = DRIVER+"://127.0.0.1:3306/"+DATABASE;
    static final String CREDENTIALS = "?user="+USERNAME+"&password="+PASSWORD;
}
