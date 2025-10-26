package racingcar.dto;

import java.util.List;

public record InputRequest(List<String> carNames, int tryCount) {
}
