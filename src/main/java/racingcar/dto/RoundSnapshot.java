package racingcar.dto;

import java.util.List;

public record ResultResponse(int round, List<RoundSnapshot> roundSnapshotList) {}
