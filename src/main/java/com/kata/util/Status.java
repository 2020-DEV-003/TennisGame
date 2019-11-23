package com.kata.util;

/**
 * 
 * @author 2020-DEV-003 Description : This enum is used to set the status of the
 *         game
 * 
 * 
 */
public enum Status {

	ALL(" All"), WINS(" Wins"), DEUCE("Deuce"), ADVANTAGE(" Advantage");
	public final String value;

	private Status(String value) {
		this.value = value;
	}

}
