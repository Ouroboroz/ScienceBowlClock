package Scoreboard;

import Clock.ClockCase;

public class Scoreboard {
	public static String[][] scoreList = new String[6][25];
	public static String[][] headingList = {{"Toss Up 1"}, {"Bonus 1"}, {"Penalty 2"}, {"Toss Up 2"}, {"Bonus 2"}, {"Penalty 1"}};
	public static String[] columnList = {"Q Type"};
	public static boolean[][] editable = new boolean[2][25];
	public static String[] columnNames = new String[25];
	public static void initScoreboard(){
		for(int n=0; n < columnNames.length; n++){
			columnNames[n] = new Integer(n+1).toString();
			editable[0][n] = true;
			editable[1][n] = true;
		}
		reset();
	}
	public static int getA(){
		int teamA = 0;
		//Toss Up Points
		for(int k = 0; k < scoreList[0].length; k++)
			teamA += binarize(scoreList[0][k]) * 4;
		for(int k = 0; k < scoreList[1].length; k++)
			teamA += binarize(scoreList[1][k]) * 10;
		for(int k = 0; k < scoreList[2].length; k++)
			teamA += binarize(scoreList[2][k]) * 4;
		return teamA;
	}
	public static int getB(){
		int teamB = 0;
		//Toss Up Points
		for(int k = 0; k < scoreList[3].length; k++)
			teamB += binarize(scoreList[3][k]) * 4;
		for(int k = 0; k < scoreList[4].length; k++)
			teamB += binarize(scoreList[4][k]) * 10;
		for(int k = 0; k < scoreList[5].length; k++)
			teamB += binarize(scoreList[5][k]) * 4;
		return teamB;
	}
	public static void reset(){
		for(int k = 0; k < scoreList.length; k++)
			for(int i = 0; i < scoreList[k].length; i++)
				scoreList[k][i] = "   ";

	}
	private static int binarize(String num){
		//If the input is blank it is 0, else 1
		if(num.equals("   ") || num.length() > 5)
			return 0;
		return 1;
	}
	public static int binarizeRow(int row){
		if(row < 3)
			return 0;
		return 1;
	}
	public static String[] getColumnNames(){
		return columnNames;
	}
	public static String[][] getScoreList(){
		return scoreList;
	}
	public static boolean[][] getEditable(){
		return editable;
	}
	public static String[] getColumnList(){
		return columnList;
	}
	public static String[][] getHeadingList(){
		return headingList;
	}
}
