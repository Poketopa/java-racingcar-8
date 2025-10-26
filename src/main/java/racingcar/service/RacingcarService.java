package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingcarRequest;
import racingcar.model.Car;

public class RacingcarService {
    public void startRace(RacingcarRequest request) {
        List<Car> carList = createCar(request.carNames());

        race(carList, request.tryCount());
    }

    private void race(List<Car> carList, int tryCount) {
    }

    private List<Car> createCar(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }


}
