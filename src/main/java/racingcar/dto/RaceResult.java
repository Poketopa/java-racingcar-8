package racingcar.dto;

import java.util.List;
import racingcar.model.Car;

public record RaceResult(List<RoundSnapshot> roundSnapshotList, List<Car> winnerList) {
}
