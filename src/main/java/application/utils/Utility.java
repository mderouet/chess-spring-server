package application.utils;

import com.google.common.base.CharMatcher;

public class Utility {

	public static int getNumberFromString(String move) {
		return Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(move));
	}

	public static String getLetterFromNumber(String move) {
		return CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).retainFrom(move);
	}

}
