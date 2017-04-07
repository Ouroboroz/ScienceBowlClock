package Scoreboard;

public class Scoreboard {
	private int[] teamADist = {0,0}, teamBDist = {0,0}; //{toss up, bonus}
	private int teamA = 0, teamB = 0;
	public void addDist(int t, int b, Team team){
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
	}
	public void updateTotal(){
		teamA = teamADist[0]*4+teamADist[1]*10;
		teamB = teamBDist[0]*4+teamBDist[1]*10;
	}
}
