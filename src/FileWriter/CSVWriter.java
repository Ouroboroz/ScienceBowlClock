package FileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Scoreboard.Scoreboard;

public class CSVWriter {
	private static String path;
	private static FileWriter fileWriter;
	private static String[] names;
	public static void setUp(String modif, String[] names){
		CSVWriter.names = names;
		path = System.getProperty("java.class.path");
		path = processPath(path);
		System.out.println(path);
		boolean mkdir = (new File(path+"scibowldata")).mkdir();
		try {
			if(new File(path+"/scibowldata").exists()){
				//System.out.println(path+"/scibowldata/scibowldata"+modif+".csv");
				fileWriter = new FileWriter(path+"/scibowldata/scibowldata"+modif+".csv");
				path += "scibowldata/scibowldata"+modif+".csv";
			}
			else{
				//System.out.println(path+"/scibowldata"+modif+".csv");
				fileWriter = new FileWriter(path+"/scibowldata"+modif+".csv");
				path += "scibowldata"+modif+".csv";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to create CSV file");
			e.printStackTrace();
		}
	}
	public static void createCSV(){
		try{
			nameHeader();
			customSpacing(",");
			customSpacing("Overall Distribution,");
			origDist();
			spacing();
			customSpacing("Toss Up Distribution,");
			playerTUDist();
			spacing();
			customSpacing("Bonus Distribution,");
			playerBDist();
			spacing();
			customSpacing("Penalty Distribution,");
			penaltyDist();
		}catch(IOException e){
			System.out.println("Unable to print onto CSV");
			e.printStackTrace();
		}
		try{
			close();
		}catch(IOException e){
			System.out.println("Cannot Close CSV");
			e.printStackTrace();
		}
	}
	private static void nameHeader() throws IOException{
		for(int c = 0; c < names.length; c++){
			fileWriter.append("P"+Integer.toString(c+1));
			fileWriter.append(",");
			fileWriter.append(names[c]);
			fileWriter.append(",");
		}
		for(int c = 0; c < 10; c++){
			fileWriter.append(",");
		}
	}
	private static void origDist() throws IOException{
		String[][] scoreList = Scoreboard.getScoreList();
		String[][] headingList = Scoreboard.getHeadingList();
		String[] columnNames = Scoreboard.getColumnNames();
		String[] columnList = Scoreboard.getColumnList();
		fileWriter.append(columnList[0]);
		fileWriter.append(",");
		for(int j = 0; j < columnNames.length; j++){
			fileWriter.append(columnNames[j]);
			fileWriter.append(",");
		}
		fileWriter.append("\n");
		for(int i = 0; i < scoreList.length; i++){
			fileWriter.append(headingList[i][0]);
			fileWriter.append(",");
			for(int k = 0; k < scoreList[i].length; k++){
				fileWriter.append(scoreList[i][k]);
				fileWriter.append(",");
			}
			fileWriter.append("\n");
		}
	}
	private static void playerTUDist() throws IOException{
		String[][] playerDist = new String[8][25];
		String[][] scoreDist = Scoreboard.getScoreList();
		String[] columnNames = Scoreboard.getColumnNames();
		for(int i = 0; i < playerDist.length; i++)
			for(int k = 0; k < playerDist[i].length; k++)
				playerDist[i][k] = " ";
		for(int i = 0; i < 1; i++)
			for(int k = 0; k < scoreDist[i].length; k++)
				if(!scoreDist[i][k].equals("   "))
					playerDist[Integer.parseInt(Character.toString(scoreDist[i][k].charAt(1)))-1][k] = "X";
		for(int i = 3; i < 4; i++)
			for(int k = 0; k < scoreDist[i].length; k++)
				if(!scoreDist[i][k].equals("   "))
					playerDist[Integer.parseInt(Character.toString(scoreDist[i][k].charAt(1)))+3][k] = "X";
	
		fileWriter.append("Player");
		fileWriter.append(",");
		for(int j = 0; j < columnNames.length; j++){
			fileWriter.append(columnNames[j]);
			fileWriter.append(",");
		}
		fileWriter.append("\n");
		for(int i = 0; i < playerDist.length; i++){
			fileWriter.append(names[i]);
			fileWriter.append(",");
			for(int k = 0; k < playerDist[i].length; k++){
				fileWriter.append(playerDist[i][k]);
				fileWriter.append(",");
			}
			fileWriter.append("\n");
		}
	}
	private static void playerBDist() throws IOException{
		String[][] playerDist = new String[8][25];
		String[][] scoreDist = Scoreboard.getScoreList();
		String[] columnNames = Scoreboard.getColumnNames();
		for(int i = 0; i < playerDist.length; i++)
			for(int k = 0; k < playerDist[i].length; k++)
				playerDist[i][k] = " ";
		for(int i = 1; i < 2; i++)
			for(int k = 0; k < scoreDist[i].length; k++)
				if(!scoreDist[i][k].equals("   "))
					playerDist[Integer.parseInt(Character.toString(scoreDist[i][k].charAt(1)))-1][k] = "X";
		for(int i = 4; i < 5; i++)
			for(int k = 0; k < scoreDist[i].length; k++)
				if(!scoreDist[i][k].equals("   "))
					playerDist[Integer.parseInt(Character.toString(scoreDist[i][k].charAt(1)))+3][k] = "X";
	
		fileWriter.append("Player");
		fileWriter.append(",");
		for(int j = 0; j < columnNames.length; j++){
			fileWriter.append(columnNames[j]);
			fileWriter.append(",");
		}
		fileWriter.append("\n");
		for(int i = 0; i < playerDist.length; i++){
			fileWriter.append(names[i]);
			fileWriter.append(",");
			for(int k = 0; k < playerDist[i].length; k++){
				fileWriter.append(playerDist[i][k]);
				fileWriter.append(",");
			}
			fileWriter.append("\n");
		}
	}
	private static void penaltyDist() throws IOException{
		String[][] playerDist = new String[8][25];
		String[][] scoreDist = Scoreboard.getScoreList();
		String[] columnNames = Scoreboard.getColumnNames();
		for(int i = 0; i < playerDist.length; i++)
			for(int k = 0; k < playerDist[i].length; k++)
				playerDist[i][k] = " ";
		for(int i = 2; i < 3; i++)
			for(int k = 0; k < scoreDist[i].length; k++)
				if(!scoreDist[i][k].equals("   "))
					playerDist[Integer.parseInt(Character.toString(scoreDist[i][k].charAt(1)))-1][k] = "X";
		for(int i = 5; i < 6; i++)
			for(int k = 0; k < scoreDist[i].length; k++)
				if(!scoreDist[i][k].equals("   "))
					playerDist[Integer.parseInt(Character.toString(scoreDist[i][k].charAt(1)))+3][k] = "X";
	
		fileWriter.append("Player");
		fileWriter.append(",");
		for(int j = 0; j < columnNames.length; j++){
			fileWriter.append(columnNames[j]);
			fileWriter.append(",");
		}
		fileWriter.append("\n");
		for(int i = 0; i < playerDist.length; i++){
			fileWriter.append(names[i]);
			fileWriter.append(",");
			for(int k = 0; k < playerDist[i].length; k++){
				fileWriter.append(playerDist[i][k]);
				fileWriter.append(",");
			}
			fileWriter.append("\n");
		}
	}
	private static void spacing() throws IOException{
		for(int k = 0; k < 2; k++){
			for(int i = 0; i < 26; i++)
				fileWriter.append(",");
			fileWriter.append("\n");
		}
		fileWriter.append("\n");
	}
	private static void customSpacing(String begin) throws IOException{
		fileWriter.append(begin);
		for(int i = 0; i < 25; i++)
			fileWriter.append(",");
		fileWriter.append("\n");
	}
	private static void close() throws IOException{
        fileWriter.flush();
        fileWriter.close();

	}
	public static String getPath(){
		return path;
	}
	private static String processPath(String pathIn){
		while(pathIn.charAt(pathIn.length()-1)!='/')
			if(pathIn.length() >= 2)
				pathIn = pathIn.substring(0, pathIn.length()-2);
		return pathIn;
	}
}
