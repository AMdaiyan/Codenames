package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class AgentSelector {
	/*
	 * This list contains all the codenames that are need for the agents.
	 */
	public ArrayList<String> CodeNames;
	/*
	 * This arraylist contains all the agents to be placed on the with their random assigned codenames.
	 */
	public ArrayList<Agent> Agents;
	
	
	
	
	
	
	/*
	 * This method takes the list of codenames created the GameWords method and randomizes it.
	 */
	public void AgentRandomizer(){
		String text = "src/Gamewords.txt";
		ArrayList<String> w = new ArrayList<String>();

		try {
			for(String line : Files.readAllLines(Paths.get(text)) ) {
				w.add(line);
		}} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.shuffle(w);
		CodeNames = w;
	}
	/*
	 * This method uses the list of random codenames and makes all the red,blue,assain,and bystander agents
	 *  assigns them each a unique code name and returns a randomized list of all twenty five agents.
	 */
	public void AgentSelector2() {
		ArrayList<String> gh =  CodeNames;
		ArrayList<Agent> ag =  new ArrayList<Agent>();
		for(int i = 0; i<9;i++) {
			ag.add(new RedAgent(gh.get(i)));
			
		}
for(int i = 9; i<17;i++) {

			ag.add(new BlueAgent(gh.get(i)));
		}
for(int i = 17; i<24;i++) {
	
	ag.add(new Bystander(gh.get(i)));
}
Agent a = new Assassin(gh.get(24));		
		ag.add(a);
		Collections.shuffle(ag);
		
		Agents = ag;
	}
	public void AgentSelector3() {
		ArrayList<String> gh =  CodeNames;
		ArrayList<Agent> ag =  new ArrayList<Agent>();
		for(int i = 0; i<6;i++) {
			ag.add(new RedAgent(gh.get(i)));
			
		}
for(int i = 6; i<11;i++) {

			ag.add(new BlueAgent(gh.get(i)));
		}
for(int i =11; i<16;i++) {
	ag.add(new GreenAgent(gh.get(i)));
}
for(int i = 16; i<23;i++) {
	
	ag.add(new Bystander(gh.get(i)));
}
for(int i = 23; i<25;i++) {
	
	ag.add(new Assassin(gh.get(i)));
}
		Collections.shuffle(ag);
		
		Agents = ag;
	}
	/*
	 * This method is used to retrieve the list of agents.
	 */
	public ArrayList<Agent> getAgents(){
		return Agents;
	}
	public ArrayList<String> getCodeNames(){
		return CodeNames;
	}
	
	
	
	
	

}
