package racingcar.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseCarNames(String rawCarNames) {
        return Arrays.asList(rawCarNames.split(","));
    }

    public int parseTryCount(String rawTryCount) {
        return Integer.parseInt(rawTryCount);
    }
}
