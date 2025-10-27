package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarSnapshot;
import racingcar.dto.InputRequest;
import racingcar.dto.RaceResult;
import racingcar.dto.RoundSnapshot;
import racingcar.model.Car;

public class RacingcarService {
    public RaceResult getRaceResult(InputRequest request) {
        List<Car> carList = createCar(request.carNames());

        List<RoundSnapshot> roundSnapshotList = race(carList, request.tryCount());
        int longestDistance = getLongestDistance(carList);
        List<Car> winnerList = findWinner(carList, longestDistance);

        return new RaceResult(roundSnapshotList, winnerList);
    }

    private List<Car> createCar(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            addCarToList(carName, carList);
        }
        return carList;
    }

    private void addCarToList(String carName, List<Car> carList) {
        Car car = new Car(carName);
        carList.add(car);
    }

    private List<RoundSnapshot> race(List<Car> carList, int tryCount) {
        List<RoundSnapshot> roundSnapshotList = new ArrayList<>();
        for (int round = 1; round <= tryCount; round++) {
            collectRoundResult(carList, roundSnapshotList, round);
        }
        return roundSnapshotList;
    }

    private void collectRoundResult(List<Car> carList, List<RoundSnapshot> roundSnapshotList, int round) {
        roundSnapshotList.add(new RoundSnapshot(round, startRace(carList)));
    }

    private List<CarSnapshot> startRace(List<Car> carList) {
        List<CarSnapshot> roundSnapshotList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            getRandomNumberAndGo(carList, i, roundSnapshotList);
        }
        return roundSnapshotList;
    }

    private void getRandomNumberAndGo(List<Car> carList, int i, List<CarSnapshot> roundSnapshotList) {
        Car car = carList.get(i);
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.go();
        }
        CarSnapshot roundSnapshot = new CarSnapshot(car.getName(), car.getDistance());
        roundSnapshotList.add(roundSnapshot);
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
            findWinners(longestDistance, car, winnerList);
        }
        return winnerList;
    }

    private static void findWinners(int longestDistance, Car car, List<Car> winnerList) {
        if (car.getDistance() == longestDistance) {
            winnerList.add(car);
        }
    }
}
