package application.util;

import com.google.common.base.CharMatcher;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

@Slf4j
public class Utils {

    public static int getNumberFromString(String move) {
        return Integer.parseInt(CharMatcher.inRange('0', '9').retainFrom(move));
    }

    public static String getLetterFromNumber(String move) {
        return CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).retainFrom(move);
    }

    public static String sha256HashFromString(String word) {
        return Hashing.sha256()
                .hashString(word, StandardCharsets.UTF_8)
                .toString();
    }
}
