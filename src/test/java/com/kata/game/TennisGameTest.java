package com.kata.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kata.constants.Constants;
import com.kata.model.Player;
import com.kata.util.Status;

/**
 * @author 2020-DEV-003 Description : This test class will unit test the
 *         TennisGame
 *
 */
public class TennisGameTest {

	Player playerOne;

	Player playerTwo;

	TennisGame tennisGame;

	@Before
	public void setUp() {
		playerOne = new Player();
		playerTwo = new Player();
		playerOne.setName(Constants.PLAYER_ONE);
		playerTwo.setName(Constants.PLAYER_TWO);
		tennisGame = new TennisGame();
	}

	@Test
	public void testGetScoreShouldReturnLoveAll() {
		playerOne.setScore(Constants.ZERO);
		playerTwo.setScore(Constants.ZERO);
		assertEquals(Constants.LOVE_ALL, tennisGame.getScore(playerOne, playerTwo));
	}

	@Test
	public void testGetScoreShouldReturnFifteenAll() {
		playerOne.setScore(Constants.ONE);
		playerTwo.setScore(Constants.ONE);
		assertEquals(Constants.FIFTEEN_ALL, tennisGame.getScore(playerOne, playerTwo));
	}

	@Test
	public void testGetScoreShouldReturnThirtyAll() {
		playerOne.setScore(Constants.TWO);
		playerTwo.setScore(Constants.TWO);
		assertEquals(Constants.THIRTY_ALL, tennisGame.getScore(playerOne, playerTwo));
	}

	public void testPlayerOneWinsFirstBall() {
		playerOne.setScore(Constants.ONE);
		playerTwo.setScore(Constants.ZERO);
		assertEquals("FIFTEEN,LOVE", tennisGame.getScore(playerOne, playerTwo));
	}

	@Test
	public void testPlayerOneWinsGame() {
		playerOne.setScore(6);
		playerTwo.setScore(0);
		assertEquals(Constants.PLAYER_ONE + Status.WINS.value, tennisGame.getScore(playerOne, playerTwo));
	}

	@Test
	public void testPlayerTwoWinsGame() {
		playerOne.setScore(2);
		playerTwo.setScore(6);
		assertEquals(Constants.PLAYER_TWO + Status.WINS.value, tennisGame.getScore(playerOne, playerTwo));
	}

}
