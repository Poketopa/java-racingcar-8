package racingcar.dto;

import java.util.List;

public record RacingcarRequest(List<String> carNames, int tryCount) {}
