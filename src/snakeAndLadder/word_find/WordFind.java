package snakeAndLadder.word_find;

import snakeAndLadder.dataLoadUtility.DataLoadUtility;
import java.util.ArrayList;
import java.util.Random;

public class WordFind {
	ArrayList<String> wordList;

	public WordFind() {
		this.wordList = DataLoadUtility.dataload("./words");
	}

	public int patternSearch(String key) {
		for (String word : wordList) {
			if (word.toLowerCase().equals(key.toLowerCase())) {
				wordList.remove(key.toLowerCase());
				return key.length();
			}
		}

		return 0;
	}

	public void printWordGrid() {
		Integer row = 0, col = 0;
		Integer max = 9;
		Integer min = 0;
		char[][] grid = new char[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = '?';
			}
		}

		for (int k = 0; k < 10; k++) {
			Random randIndex = new Random();

			String s = wordList.get(randIndex.nextInt(wordList.size() - 1));

			Integer srow = ((int) Math.floor(Math.random() * (max - min + 1)));
			Integer scol = (int) Math.floor(Math.random() * (max - min + 1));

			col = 0;
			for (char c : s.toCharArray()) {

				if (grid[srow][col] == '?') {
					grid[srow][col++] = Character.toUpperCase(c);
				}
			}

			row = 0;

			for (char c : s.toCharArray()) {

				if (grid[row][scol] == '?') {
					grid[row++][scol] = Character.toUpperCase(c);
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Random rnd = new Random();
				if (grid[i][j] == '?') {
					grid[i][j] = Character.toUpperCase((char) ('A' + rnd.nextInt(26)));
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(grid[i][j]+"\t" );
			}
			System.out.println();
		}
	}
}
