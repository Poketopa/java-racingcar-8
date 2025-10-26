package racingcar.dto;

import java.util.List;

public record RoundSnapshot(int round, List<CarSnapshot> carSnapshotList) {
}
