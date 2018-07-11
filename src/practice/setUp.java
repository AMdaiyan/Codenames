
package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class SetUp {

	/**
	 * @return This method should return A list contains all the words from the
	 *         txt file
	 */
	public static ArrayList<String> GameWords() {

		String text = "GameWords2.txt";
		ArrayList<String> line = null;

		try {
			line = (ArrayList<String>) Files.readAllLines(Paths.get(text));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return line;

	}

	/**
	 * 
	 * @return A 2d array the contains 25 strings
	 */
	public static String[][] board() {
		String[][] game = new String[5][5];

		return game;
	}

	public void shuffle() {
		Collections.shuffle(GameWords());
	}

	public static void main(String[] args) {

	}

}
