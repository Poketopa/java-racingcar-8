package racingcar.controller;

import racingcar.parser.InputParser;
import racingcar.service.RacingcarService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final RacingcarService racingcarService;
    private final InputParser inputParser;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingcarController(RacingcarService racingcarService,
                               InputParser inputParser, InputView inputView, OutputView outputView) {
        this.racingcarService = racingcarService;
        this.inputParser = inputParser;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        // 이름 입력
        String rawCarNames = inputView.inputCarNames();
        // 시도 횟수 입력
        String rawTryCount = inputView.inputTryCount();
        // 이름 검증




        // 시도 횟수 검증

        // N번 실행
    }
}
