package practice;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class RandomizerTests {

	
	
	
	
	
	@Test
	public void AgentSelector2Test() {
		AgentSelector ag = new AgentSelector();
		ag.AgentRandomizer();
		ag.AgentSelector2();
		assertEquals(ag.getAgents().size(),25,0);
	}
	
	
	
	
	
	
	
	
}
