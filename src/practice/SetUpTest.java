package practice;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class SetUpTest {

	@Test
	public void testGameWord() {
		
		AgentSelector as = new AgentSelector();
		String text = "GameWords2.txt";
		List<String> line = null;
		List<String> a = as.AgentRandomizer();
		try {
			line = Files.readAllLines(Paths.get(text));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("two list should alwats return the same list of words", line, SetUp.GameWords());
		for (int i = 0; i < line.size(); i++) {
			assertTrue("two lists should not have the same order of words", line.get(i) != (a.get(i)));
		}
	}

	@Test
	public void testBoard() {

		String[][] game = new String[5][5];
		game = SetUp.board();
		assertTrue("test the length of the game board", game.length == 5);
		assertTrue("test the width of the game board", game[1].length == 5);

	}
}
