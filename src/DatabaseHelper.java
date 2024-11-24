import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String DATABASE_URL = "jdbc:sqlite:src/database/agenda.db"; // SQLite file name

    public DatabaseHelper() {
        createTable(); // Automatically create the table when the helper is initialized
    }

    private void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS agenda ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "date TEXT NOT NULL, "
                + "description TEXT NOT NULL, "
                + "time TEXT NOT NULL, "
                + "ampm TEXT NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL); // Execute the table creation query
            System.out.println("Table 'agenda' is ready!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(DATABASE_URL);
    }
}
