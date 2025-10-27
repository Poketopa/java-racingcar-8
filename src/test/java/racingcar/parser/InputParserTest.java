package racingcar.parser;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    private final InputParser parser = new InputParser();

    @Test
    void 자동차이름_파싱() {
        List<String> names = parser.parseCarNames("pobi,woni,jun");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 시도횟수_파싱() {
        int tryCount = parser.parseTryCount("5");
        assertThat(tryCount).isEqualTo(5);
    }
}
