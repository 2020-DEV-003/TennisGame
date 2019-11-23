package com.kata.model;

/**
 * 
 * @author 2020-DEV-003 Description : This model is used to set player
 *         attributes
 * 
 */
public class Player {

	private int score = 0;
	private String name;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
