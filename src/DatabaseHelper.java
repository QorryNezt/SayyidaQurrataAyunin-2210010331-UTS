import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:src/database/agenda.db"; // Your SQLite database file

    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS agenda ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "date TEXT NOT NULL, "
                + "description TEXT NOT NULL, "
                + "time TEXT NOT NULL, "
                + "ampm TEXT NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            System.out.println("Table 'agenda' created or already exists!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}