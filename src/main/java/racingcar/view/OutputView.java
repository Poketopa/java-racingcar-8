package racingcar.view;

import java.util.List;
import racingcar.dto.CarSnapshot;
import racingcar.dto.RaceResult;
import racingcar.dto.RoundSnapshot;
import racingcar.model.Car;

public class OutputView {
    public void printRaceResult(List<String> carNameList, int tryCount, RaceResult raceResult) {
        printResult(carNameList, tryCount, raceResult.roundSnapshotList());
        printWinners(raceResult.winnerList());
    }

    private void printResult(List<String> carNameList, int tryCount, List<RoundSnapshot> roundSnapshotList) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            RoundSnapshot roundSnapshot = roundSnapshotList.get(i);
            List<CarSnapshot> carSnapshotList = roundSnapshot.carSnapshotList();
            for (int j = 0; j < carNameList.size(); j++) {
                CarSnapshot carSnapshot = carSnapshotList.get(j);
                int distance = carSnapshot.distance();
                System.out.println(carNameList.get(j) + " : " + "-".repeat(distance));
            }
            System.out.println();
        }
    }

    private void printWinners(List<Car> winnerList) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            Car winner = winnerList.get(i);
            if (i == winnerList.size() - 1) {
                System.out.print(winner.getName());
            }
            if (i < winnerList.size() - 1) {
                System.out.print(winner.getName() + ", ");
            }
        }
    }
}
