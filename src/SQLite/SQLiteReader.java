package SQLite;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLiteReader {
	ArrayList<SQLiteItem> questionsArray = new ArrayList<SQLiteItem>(); 
	private Connection connect() {
		String url = "jdbc:sqlite:./Resources/db/test.db";
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url);
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void selectAll(String round){
		questionsArray.clear();
		String sql = "SELECT question, answer FROM questions WHERE round ==\""+round+"\"";
		try(Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()){
				questionsArray.add(new SQLiteItem(rs.getString("question"), rs.getString("answer")));
			}
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<SQLiteItem> getQuestionsArray(){
		return questionsArray;
	}
}
