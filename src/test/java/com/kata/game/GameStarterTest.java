/**
 * 
 */
package com.kata.game;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.kata.constants.Constants;
import com.kata.model.Player;

/**
 * @author 2020-DEV-003 Description : This test class will unit test the
 *         GameStarter
 *
 */
public class GameStarterTest {

	Player playerOne;

	Player playerTwo;

	GameStarter gameStarter;

	@Before
	public void setUp() {
		playerOne = new Player();
		playerTwo = new Player();
		playerOne.setName(Constants.PLAYER_ONE);
		playerTwo.setName(Constants.PLAYER_TWO);
		gameStarter = new GameStarter(playerOne, playerTwo);
	}

	@Test
	public void testStartMethodIsWorking() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = GameStarter.class.getDeclaredMethod("start");
		method.setAccessible(true);
		method.invoke(gameStarter);
		assertTrue(playerOne.getScore() == Constants.SIX || playerTwo.getScore() == Constants.SIX);
	}

	@Test
	public void testSetScoreMethodSetsCorrectScore() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		playerOne.setScore(Constants.FIVE);
		playerTwo.setScore(Constants.THREE);
		Method method = GameStarter.class.getDeclaredMethod("setScore", String.class);
		method.setAccessible(true);
		method.invoke(gameStarter, Constants.PLAYER_TWO);
		assertTrue(playerOne.getScore() == Constants.FOUR);
	}
}
