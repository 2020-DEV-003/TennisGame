package com.kata.game;

import com.kata.constants.Constants;
import com.kata.model.Player;
import com.kata.util.Status;

/**
 * @author 2020-DEV-003 Description : This is the main class that starts the
 *         game and decide the winner
 *
 */
public class GameStarter {

	Player playerOne;

	Player playerTwo;

	TennisGame tennisGame;

	public GameStarter(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	/**
	 * @Description: Start the game for playerOne and playerTwo. Random value
	 *               generated to decide who wins the ball and finally decide winner
	 *               of the game based on points
	 * 
	 */
	private void start() {
		playerOne.setName(Constants.PLAYER_ONE);
		playerTwo.setName(Constants.PLAYER_TWO);
		playerOne.setScore(Constants.ZERO);
		playerTwo.setScore(Constants.ZERO);
		boolean gameEnds = false;
		while (!gameEnds) {
			String ballWinner = null;
			int randomNumber = (int) (Math.random() * 10);
			if (randomNumber % 2 == 0) {
				ballWinner = Constants.PLAYER_ONE;
				setScore(Constants.PLAYER_ONE);
			} else {
				ballWinner = Constants.PLAYER_TWO;
				setScore(Constants.PLAYER_TWO);
			}
			System.out.println(ballWinner + " wins the ball");
			TennisGame game = new TennisGame();
			String result = game.getScore(playerOne, playerTwo);
			System.out.println(result);
			gameEnds = (result.contains(Status.WINS.value));
		}
	}

	/**
	 * @Description: This method sets the scores of the players after deciding the
	 *               winner of every ball
	 * @param winner: String
	 */
	private void setScore(String winner) {
		if (winner.equalsIgnoreCase(Constants.PLAYER_ONE)) {
			if (playerOne.getScore() == Constants.FOUR) {
				playerOne.setScore(Constants.FIVE);
				playerTwo.setScore(Constants.THREE);
			} else if ((playerOne.getScore() == Constants.TWO && playerTwo.getScore() == Constants.THREE)
					|| (playerOne.getScore() == Constants.THREE && playerTwo.getScore() == Constants.FIVE)) {
				playerOne.setScore(Constants.FOUR);
				playerTwo.setScore(Constants.FOUR);
			} else if (playerOne.getScore() == Constants.THREE && playerTwo.getScore() != Constants.FIVE) {
				playerOne.setScore(Constants.SIX);
			} else if (playerOne.getScore() == Constants.FIVE) {
				playerOne.setScore(Constants.SIX);
			} else {
				playerOne.setScore(playerOne.getScore() + 1);
			}
		} else {
			if (playerTwo.getScore() == Constants.FOUR) {
				playerTwo.setScore(Constants.FIVE);
				playerOne.setScore(Constants.THREE);
			} else if ((playerTwo.getScore() == Constants.TWO && playerOne.getScore() == Constants.THREE)
					|| (playerTwo.getScore() == Constants.THREE && playerOne.getScore() == Constants.FIVE)) {
				playerOne.setScore(Constants.FOUR);
				playerTwo.setScore(Constants.FOUR);
			} else if (playerTwo.getScore() == Constants.THREE && playerOne.getScore() != Constants.FIVE) {
				playerTwo.setScore(Constants.SIX);
			} else if (playerTwo.getScore() == Constants.FIVE) {
				playerTwo.setScore(Constants.SIX);
			} else {
				playerTwo.setScore(playerTwo.getScore() + 1);
			}

		}
	}

	public static void main(String[] dhileepan) {
		GameStarter gameStarter = new GameStarter(new Player(), new Player());
		gameStarter.start();
	}
}
