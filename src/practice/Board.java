package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Board {
	public  ArrayList<String> GameWords(){
		
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
	public static Agent[][] board() {
		Agent[][] game = new Agent[5][5];

		return game;
	}

}
