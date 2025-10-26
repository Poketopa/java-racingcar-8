package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final RacingcarService racingcarService = new RacingcarService();
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        final RacingcarController racingcarController =
                new RacingcarController(racingcarService, inputView, outputView);

        racingcarController.run();
    }
}
