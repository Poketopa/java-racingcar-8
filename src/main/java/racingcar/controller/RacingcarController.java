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
        // 이름 입력
        String carName = inputView.inputCarName();

        // 이름 검증

        // 시도 횟수 입력

        // 시도 횟수 검증

        // N번 실행
    }
}
