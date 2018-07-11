package practice;

public class Bystander extends Agent {
	/*
	This instance variable holds the code name of each Agent.
	*/
	private String codeName;
	
	/*
	 This instance variable holds an integer unique to this type of agent. This is done for easy identification of what type of agent this is. 
	 */
	private int allignment= 3;
	private boolean hidden = false;
	/*
	  * This constructor is used so that when the agent is created they are given their unique codename.
	  * 
	  */
	public Bystander(String a) {
		 codeName = a;
		
	}
	 /*
	  * This is used to retrieve the codename of the agent so it can be checked if the guess was correct.
	  * 
	  * 
	  */
	@Override
	 public String getcodeName() {
			return codeName;
			 
		 }
	 /*
	  * This method is used to retrieve the alignment of the agent so they can be checked for the type of agent they are.
	  */
	@Override
	 public int getAllignment() {
		  return allignment;
	  }
	 @Override
	 public boolean getHidden() {
		 return hidden;
	 }
	 @Override
	 public void reveal() {
		 hidden = true;
	 }
}
