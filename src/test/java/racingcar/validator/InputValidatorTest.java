package racingcar.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    void 자동차이름_정상입력() {
        assertThatCode(() -> validator.validateCarNames("pobi,woni,jun"))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차이름_빈문자열_예외() {
        assertThatThrownBy(() -> validator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_공백토큰_예외() {
        assertThatThrownBy(() -> validator.validateCarNames("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_5자초과_예외() {
        assertThatThrownBy(() -> validator.validateCarNames("pobi,javaji"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_특수문자_예외() {
        assertThatThrownBy(() -> validator.validateCarNames("po$bi,woni"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_정상입력() {
        assertThatCode(() -> validator.validateTryCount("3"))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도횟수_숫자아님_예외() {
        assertThatThrownBy(() -> validator.validateTryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_0또는음수_예외() {
        assertThatThrownBy(() -> validator.validateTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateTryCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
