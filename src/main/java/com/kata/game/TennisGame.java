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
		int playerOneScore = playerOne.getScore();
		int playerTwoScore = playerTwo.getScore();
		if (isWin(playerOneScore, playerTwoScore)) {
			if (playerOneScore > playerTwoScore) {
				return playerOne.getName() + Status.WINS.value;
			} else {
				return playerTwo.getName() + Status.WINS.value;
			}
		}
		if (isAdvantage(playerOneScore, playerTwoScore)) {
			if (playerOneScore > playerTwoScore) {
				return playerOne.getName() + Status.ADVANTAGE.value;
			} else {
				return playerTwo.getName() + Status.ADVANTAGE.value;
			}
		}
		if (isDeuce(playerOneScore, playerTwoScore)) {
			return Status.DEUCE.value;
		}
		if (isAll(playerOneScore, playerTwoScore)) {
			return Points.get(playerOneScore) + Status.ALL.value;
		}
		return Points.get(playerOneScore) + Constants.COMMA + Points.get(playerTwoScore);
	}

	private boolean isWin(int playerOneScore, int playerTwoScore) {
		boolean isWinFlag = false;
		if (playerOneScore > Constants.FIVE || playerTwoScore > Constants.FIVE) {
			isWinFlag = true;
		}
		return isWinFlag;
	}

	private boolean isAdvantage(int playerOneScore, int playerTwoScore) {
		boolean isAdvFlag = false;
		if ((playerOneScore > playerTwoScore && playerTwoScore >= Constants.THREE)
				|| (playerOneScore < playerTwoScore && playerOneScore >= Constants.THREE)) {
			isAdvFlag = true;
		}
		return isAdvFlag;
	}

	private boolean isDeuce(int playerOneScore, int playerTwoScore) {
		boolean isDeuceFlag = false;
		if (playerOneScore == playerTwoScore && playerOneScore >= Constants.THREE) {
			isDeuceFlag = true;
		}
		return isDeuceFlag;
	}

	private boolean isAll(int playerOneScore, int playerTwoScore) {
		boolean isAllFlag = false;
		if (playerOneScore == playerTwoScore && playerOneScore < Constants.THREE) {
			isAllFlag = true;
		}
		return isAllFlag;
	}
}
