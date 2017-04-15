package SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class Main {
 
    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:./Resources/SQLite/Questions.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS questions (\n"
                + "	round INTEGER NOT NULL,\n"
                + "	'question number' INTEGER NOT NULL,\n"
                + " question TEXT NOT NULL,\n"
                + "	a TEXT, \n"
                + " b TEXT, \n"
                + " c TEXT, \n"
                + " d TEXT, \n"
                + " PRIMARY KEY(round, 'question number')\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            sql = "INSERT INTO question(round, 'question number', question, a, b, c, d) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString
            sql = "SELECT * FROM questions;";
            ResultSet set = stmt.executeQuery(sql);
           	while(set.next())
           		set.getString("question");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }
 
}