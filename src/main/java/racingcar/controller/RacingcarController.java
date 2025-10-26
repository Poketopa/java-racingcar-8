package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingcarRequest;
import racingcar.parser.InputParser;
import racingcar.service.RacingcarService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final RacingcarService racingcarService;
    private final InputValidator inputValidator;
    private final InputParser inputParser;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingcarController(RacingcarService racingcarService,
                               InputValidator inputValidator, InputParser inputParser, InputView inputView, OutputView outputView) {
        this.racingcarService = racingcarService;
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        String rawCarNames = inputView.inputCarNames();
        String rawTryCount = inputView.inputTryCount();

        inputValidator.validateCarNames(rawCarNames);
        inputValidator.validateTryCount(rawTryCount);

        List<String> carNames = inputParser.parseCarNames(rawCarNames);
        int tryCount = inputParser.parseTryCount(rawTryCount);
        RacingcarRequest request = new RacingcarRequest(carNames, tryCount);

        racingcarService.startRace(request);








        // 시도 횟수 검증

        // N번 실행
    }
}
