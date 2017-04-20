package SQLite;

public class SQLiteItem {
	private String question, answer;
	public SQLiteItem(String q, String a){
		question = q;
		answer = a;
	}
	public void setQuestion(String q){
		question = q;
	}
	public void setAnswer(String a){
		answer = a;
	}
	public String getQuestion(){
		return question;
	}
	public String getAnswer(){
		return answer;
	}
}
