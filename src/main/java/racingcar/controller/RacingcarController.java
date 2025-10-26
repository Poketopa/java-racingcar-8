package racingcar.controller;

import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final RacingcarService racingcarService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingcarController(RacingcarService racingcarService, InputView inputView, OutputView outputView) {
        this.racingcarService = racingcarService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){

    }
}
