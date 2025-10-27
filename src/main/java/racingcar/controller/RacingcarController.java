package racingcar.controller;

import java.util.List;
import racingcar.dto.RaceResult;
import racingcar.dto.InputRequest;
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
                               InputValidator inputValidator, InputParser inputParser, InputView inputView,
                               OutputView outputView) {
        this.racingcarService = racingcarService;
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String rawCarNames = inputView.inputCarNames();
        String rawTryCount = inputView.inputTryCount();

        inputValidator.validateCarNames(rawCarNames);
        inputValidator.validateTryCount(rawTryCount);

        List<String> carNames = inputParser.parseCarNames(rawCarNames);
        int tryCount = inputParser.parseTryCount(rawTryCount);

        InputRequest request = new InputRequest(carNames, tryCount);
        RaceResult raceResult = racingcarService.getRaceResult(request);

        outputView.printRaceResult(carNames, tryCount, raceResult);
    }
}
