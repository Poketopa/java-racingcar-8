package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.exception.CarNameInvalidException;
import racingcar.exception.TryCountInvalidException;
import racingcar.model.Car;

public class InputValidator {
    private static final Pattern SPECIAL_ASCII = Pattern.compile("[^\\p{L}\\p{N}]");

    public void validateCarNames(String carNames) {
        if(carNames == null || carNames.isBlank()) {
            throw new CarNameInvalidException("자동차 이름은 공백일 수 없습니다.");
        }
        // null, 공백이면 안됨
        List<String> carNamesList = Arrays.asList(carNames.split(","));

        for (String name : carNamesList) {
            if (name.isBlank()) {
                throw new CarNameInvalidException("자동차 이름은 공백일 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new CarNameInvalidException("자동차 이름의 길이는 5 이하여야 합니다.");
            }
            if (SPECIAL_ASCII.matcher(name).find()) {
                throw new CarNameInvalidException("자동차 이름에는 특수문자가 포함되지 않아야 합니다.");
            }
        }
    }

    public void validateTryCount(String tryCount) {
        int testNumber;

        try {
            testNumber = Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new TryCountInvalidException("잘못된 시도 횟수 입력입니다.");
        }

        if(testNumber <= 0){
            throw new TryCountInvalidException("시도 횟수는 자연수여야 합니다.");
        }
    }
}
