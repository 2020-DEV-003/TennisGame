package com.kata.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 2020-DEV-003 Description : This enum is used while calculating scores
 *         of the game
 * 
 */
public enum Points {

	LOVE(0);

	private static final Map<Integer, Points> LOOKUP = new HashMap<>();

	static {
		for (Points pointsEnum : Points.values())
			LOOKUP.put(pointsEnum.getPoint(), pointsEnum);
	}

	private Points(final int point) {
		this.point = point;
	}

	private int point;

	public int getPoint() {
		return point;
	}

	public static Points get(int point) {
		return LOOKUP.get(point);
	}

}