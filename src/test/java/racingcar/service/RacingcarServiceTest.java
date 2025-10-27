package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.InputRequest;
import racingcar.dto.RaceResult;
import racingcar.model.Car;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class RacingcarServiceTest {
    private final RacingcarService service = new RacingcarService();

    @Test
    void 라운드별_스냅샷과_우승자_계산() {
        InputRequest req = new InputRequest(List.of("pobi", "woni"), 1);

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    RaceResult result = service.getRaceResult(req);

                    // then
                    assertThat(result.roundSnapshotList()).hasSize(1);
                    List<Car> winners = result.winnerList();
                    assertThat(winners).extracting(Car::getName).containsExactly("pobi");
                },
                4, 3
        );
    }
}
