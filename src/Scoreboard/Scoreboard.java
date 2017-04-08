package Scoreboard;

public class Scoreboard {
	private static final int[] startDist = {0,0};
	private static int[] teamADist = {0,0}, teamBDist = {0,0}; //{toss up, bonus}
	private static int teamA = 0, teamB = 0;
	public static void addDist(int t, int b, Team team){
		switch(team){
			case A:
				teamADist[0] += t;
				teamADist[1] += b;
				break;
			case B:
				teamBDist[0] += t;
				teamBDist[1] += b;
				break;
		}
		updateTotal();
	}
	public static void updateTotal(){
		teamA = teamADist[0]*4+teamADist[1]*10;
		teamB = teamBDist[0]*4+teamBDist[1]*10;
	}
	public static int getA(){
		return teamA;
	}
	public static int getB(){
		return teamB;
	}
	public static int[] getADist(){
		return teamADist;
	}
	public static int[] getBDist(){
		return teamBDist;
	}
	public static void reset(){
		teamADist = startDist;
		teamBDist = startDist;
		teamA = 0;
		teamB = 0;
	}
}
