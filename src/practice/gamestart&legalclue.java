package practice;

import java.util.ArrayList;
import java.util.HashMap;

/* hashmap (agentname,boolean);
 * if the value of boolean shows true, this agent has revealed*/
public class Game {
	public HashMap<String,Boolean> agents;
	private ArrayList<String> namesselected;
	private String[][] locationinstances;
	private String whosturn;
	
	public Game(ArrayList<String> al){
		namesselected=al;
		}
	
/* this method is used to know if the agent has been revealed*/
	public boolean revealstate(String agentname) {
		return agents.get(agentname);
	}
	public String turn() {
		return whosturn;
	}
	
	
	
	public void gamestart() {
		whosturn="red";
		agents =new HashMap<String,Boolean>();
		locationinstances=new String[5][5];
		for(String name: namesselected) {
			agents.put(name,false);}
		for(int i=0;i<5;i++) {
			for(int n=0;n<5;i++) {
				for(int a=0;a<25;a++) {
					locationinstances[i][n]=namesselected.get(a);}
				}
			}
		}
	
	
	public boolean legalclue(String clue){
			if(agents.containsKey(clue)){
				if(revealstate(clue)) {
					return true;
				}
				else {return false;}
			}
			else {
				return true;}
	}
	public boolean choice (int x,int y){
		if(agents.get(locationinstances[x][y])) {
			return true;
		}
		else {
			return false;
		}
	}
}


/*When game started, it is Red team's move and each of Board's 25 Location instances is assigned a codename, Person, and is Not Revealed [15 points]
Method defined which correctly returns if a clue is legal or illegal (clues cannot equal a current codename unless that codename is in a locations that was already Revealed) [10 points]
*/
