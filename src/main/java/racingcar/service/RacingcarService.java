package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarSnapshot;
import racingcar.dto.RaceResult;
import racingcar.dto.RacingcarRequest;
import racingcar.dto.RoundSnapshot;
import racingcar.model.Car;

public class RacingcarService {
    public RaceResult startRace(RacingcarRequest request) {
        List<Car> carList = createCar(request.carNames());

        List<RoundSnapshot> roundSnapshotList = race(carList, request.tryCount());

        int longestDistance = getLongestDistance(carList);

        List<Car> winnerList = findWinner(carList, longestDistance);

        return new RaceResult(roundSnapshotList, winnerList);
    }

    private List<Car> createCar(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    private List<RoundSnapshot> race(List<Car> carList, int tryCount) {
        List<RoundSnapshot> roundSnapshotList = new ArrayList<>();
        for (int round = 1; round <= tryCount; round++) {
            roundSnapshotList.add(new RoundSnapshot(round, getRandomNumberAndGo(carList)));
        }
        return roundSnapshotList;
    }

    private List<CarSnapshot> getRandomNumberAndGo(List<Car> carList) {
        List<CarSnapshot> roundSnapshotList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.go();
            }
            CarSnapshot roundSnapshot = new CarSnapshot(car.getName(), car.getDistance());
            roundSnapshotList.add(roundSnapshot);
        }
        return roundSnapshotList;
    }

    private int getLongestDistance(List<Car> carList) {
        int longestDistance = Integer.MIN_VALUE;
        for (Car car : carList) {
            longestDistance = Math.max(longestDistance, car.getDistance());
        }
        return longestDistance;
    }

    private List<Car> findWinner(List<Car> carList, int longestDistance) {
        List<Car> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getDistance() == longestDistance) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }


}
