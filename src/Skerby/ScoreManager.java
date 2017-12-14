/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * This class manage score, collect score, load score
 * from text file, sort the score, and write data into a file .
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class ScoreManager {

	private List<Score> nameAndScore = new ArrayList<>();
	private Score[] fiveScore = new Score[5];
	private Player player;
	private EnterYourName eyn;

	/*
	 * This constructor call read text file method
	 * and sort score method.
	 */
	public ScoreManager() {
		loadTextScore();
		sortScore();
	}

	/**
	 * This method load information from text file and 
	 * check if cannot load a file or cannot find file location. 
	 */
	private InputStream readTextScore() {
		//if jar file (score.txt)
		String filename = "data/score.txt";
		ClassLoader loader = ScoreManager.class.getClassLoader();
		InputStream in = loader.getResourceAsStream(filename);
		if (in == null) {
			System.out.println("Error reading file from: " + filename);
			return null;
		}
		return in;
	}

	/**
	 * This method read name and score from text file
	 * and collect the data into arraylist.
	 */
	public void loadTextScore() {
		InputStream in = readTextScore();
		Scanner readText = new Scanner(in);
		while (readText.hasNextLine()) {
			String list = readText.nextLine();
			if (list.startsWith("#")) {
				continue;
			}
			String name = list.split(",")[0].trim();
			int score = Integer.parseInt(list.split(",")[1].trim());
			Score scores = new Score(name, score);
			nameAndScore.add(scores);
		}
		readText.close();
	}

	/*
	 * This method record the name and score of player
	 * when player end game in each round to text file.
	 * */
	public static void recordScore() {
		//if jar file(score.txt)
		String outputfile = "src/data/score.txt";
		OutputStream out = null;
		try {
			out = new FileOutputStream(outputfile, true);
		} catch (FileNotFoundException ex) {
			System.out.println("Couldn't open output file " + outputfile);
			return;
		}
		PrintStream printOut = new PrintStream(out);
		printOut.printf("%s , %d\n", EnterYourName.yourName, Player.getScore());
		printOut.close();

	}

	/*
	 * This method sorts score from arraylist and manage to array
	 * to prepare score in the board.
	 * */
	public void sortScore() {
		boolean check = true;
		outerloop: for (int round = 0; round < 5; round++) {
			for (int i = 0; i < nameAndScore.size(); i++) {
				for (int j = 0; j < nameAndScore.size(); j++) {
					if (nameAndScore.get(i).getScore() < nameAndScore.get(j)
							.getScore()) {
						check = false;
					}
				}
				if (check) {
					fiveScore[round] = nameAndScore.get(i);
					nameAndScore.remove(i);
					continue outerloop;
				}
				check = true;
			}
		}
	}

	/**
	 * get top 5 scores and names from text file with sort scores.
	 * @return 5 names and scores of players.
	 */
	public Score[] getNameScores() {
		return fiveScore;
	}

	/*
	 * This method deletes information in arraylist.
	 * */
	public void deleteInformation() {
		for (int i = 0; i < nameAndScore.size(); i++) {
			nameAndScore.remove(i);
		}
	}
}