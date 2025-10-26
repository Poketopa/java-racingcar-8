package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.parser.InputParser;
import racingcar.service.RacingcarService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputValidator inputValidator = new InputValidator();
        final RacingcarService racingcarService = new RacingcarService();
        final InputParser inputParser = new InputParser();
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        final RacingcarController racingcarController =
                new RacingcarController(racingcarService, inputValidator, inputParser, inputView, outputView);

        racingcarController.run();
    }
}
