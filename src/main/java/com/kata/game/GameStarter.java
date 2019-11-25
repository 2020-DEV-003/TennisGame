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
			if ((int) (Math.random() * 10) % 2 == 0) {
				ballWinner = Constants.PLAYER_ONE;
				setScore(playerOne, playerTwo);
			} else {
				ballWinner = Constants.PLAYER_TWO;
				setScore(playerTwo, playerOne);
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
	 *               winner of every ball. First argument is the winner of the ball.
	 * @param player      Player
	 * @param otherPlayer Player
	 */
	private void setScore(Player player, Player otherPlayer) {
		if (player.getScore() == Constants.FOUR) {
			player.setScore(Constants.FIVE);
			otherPlayer.setScore(Constants.THREE);
		} else if ((player.getScore() == Constants.TWO && otherPlayer.getScore() == Constants.THREE)
				|| (player.getScore() == Constants.THREE && otherPlayer.getScore() == Constants.FIVE)) {
			player.setScore(Constants.FOUR);
			otherPlayer.setScore(Constants.FOUR);
		} else if (player.getScore() == Constants.THREE && otherPlayer.getScore() != Constants.FIVE) {
			player.setScore(Constants.SIX);
		} else if (player.getScore() == Constants.FIVE) {
			player.setScore(Constants.SIX);
		} else {
			player.setScore(player.getScore() + 1);
		}
	}

	public static void main(String[] dhileepan) {
		GameStarter gameStarter = new GameStarter(new Player(), new Player());
		gameStarter.start();
	}
}
