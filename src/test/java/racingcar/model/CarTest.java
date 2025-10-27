package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void go_호출시_거리_1증가() {
        Car car = new Car("pobi");
        int before = car.getDistance();

        car.go();

        assertThat(car.getDistance()).isEqualTo(before + 1);
    }

    @Test
    void 이름은_생성시_설정된다() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
}
