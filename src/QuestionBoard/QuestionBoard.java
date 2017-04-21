package QuestionBoard;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import SQLite.SQLiteReader;

public class QuestionBoard extends JFrame {
	private JPanel overallPanel, roundPanel, typeNnumberNtopicPanel, questionPanel, answerPanel, buttonPanel;
	private JButton showAnswer, nextQuestion, previousQuestion;
	private JLabel type, round, topic, questionNumber, question, answer;
	private JComboBox<String> roundDropdown;
	private String[] dropdownChoices = {"round1","round-1C"};
	private int arrayNumber = 0;
	GridBagConstraints c;
	
	public QuestionBoard(){
		c = new GridBagConstraints();
		overallPanel = new JPanel();
			overallPanel.setLayout(new GridBagLayout());
		roundPanel = new JPanel();
			roundPanel.setLayout(new GridBagLayout());
			roundPanel.add(round);
		typeNnumberNtopicPanel = new JPanel();
			typeNnumberNtopicPanel.setLayout(new GridBagLayout());
			c.gridx = 0;
			typeNnumberNtopicPanel.add(type, c);
			c.gridx = 1;
			typeNnumberNtopicPanel.add(questionNumber,c);
			c.gridx = 2;
			typeNnumberNtopicPanel.add(topic,c);
		questionPanel = new JPanel();
			questionPanel.setLayout(new GridBagLayout());
			questionPanel.add(question);
		answerPanel = new JPanel();
			answerPanel.setLayout(new GridBagLayout());
			c.gridx = 0;
			c.weightx = 0.7;
			answerPanel.add(answer, c);
			c.gridx = 1;
			c.weightx = 0.3;
			answerPanel.add(showAnswer,c);
		roundDropdown = new JComboBox<String>();
		buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridBagLayout());
		showAnswer = new JButton("Show Answer");
		nextQuestion = new JButton("Next Question");
		previousQuestion = new JButton("Previous Question");
		type = new JLabel("Science");
		round = new JLabel("Bowl");
		topic = new JLabel("Clock");
		questionNumber = new JLabel("0");
		question = new JLabel("Example Question");
		answer = new JLabel("Example Answer");
	}
	public void newQuestionUpdate(){
		updateQuestionNumber();
		updateType();
		updateTopic();
		updateQuestion();
		updateAnswer();
	}
	public void updateQuestionNumber(){
		questionNumber.setText(""+SQLiteReader.getQuestionsArray().get(arrayNumber).getQuestionNumber());
	}
	public void updateType(){
		type.setText(SQLiteReader.getQuestionsArray().get(arrayNumber).getType());
	}
	public void updateTopic(){
		type.setText(SQLiteReader.getQuestionsArray().get(arrayNumber).getTopic());
	}
	public void updateQuestion(){
		question.setText(SQLiteReader.getQuestionsArray().get(arrayNumber).getQuestion());
	}
	public void updateAnswer(){
		answer.setText(SQLiteReader.getQuestionsArray().get(arrayNumber).getAnswer());
	}
	public void increaseQuestionNumber(boolean isIncrease){
		if(isIncrease){
			arrayNumber++;
			if(arrayNumber >= SQLiteReader.getQuestionsArray().size())
				arrayNumber += SQLiteReader.getQuestionsArray().size()-1;
		}
		else{
			arrayNumber--;
			if(arrayNumber < 0)
				arrayNumber = 0;
		}
	}
}