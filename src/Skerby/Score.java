/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

/**
 * This class collect the data of name and score.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class Score {

	private String name;
	private int score;

	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return String.format("%-60s %5d", name, score);
	}
}
