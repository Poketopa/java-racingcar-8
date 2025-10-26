package racingcar.service;

import racingcar.validator.InputValidator;

public class RacingcarService {
    private final InputValidator inputValidator;

    public RacingcarService(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }
}
