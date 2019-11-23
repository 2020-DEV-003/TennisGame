package com.kata.game;

import com.kata.constants.Constants;
import com.kata.model.Player;
import com.kata.util.Points;
import com.kata.util.Status;

/**
 * @author 2020-DEV-003 Description : This class contain logic for Tennis Game
 *
 */
public class TennisGame {

	/**
	 * Description : This method used to get the scores of both the players
	 * 
	 * @param playerOne - Player
	 * @param playerTwo - Player
	 * @return String
	 */
	public String getScore(Player playerOne, Player playerTwo) {
		String score = "";
		if (playerOne.getScore() == Constants.ZERO && playerTwo.getScore() == Constants.ZERO) {
			score = Points.get(Constants.ZERO) + Status.ALL.value;
		}
		return score;
	}
}
