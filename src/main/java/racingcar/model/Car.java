package racingcar.model;

public class Car {
    String name;
    int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void go() {
        distance++;
    }
}
