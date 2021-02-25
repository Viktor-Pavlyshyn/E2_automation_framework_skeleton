package reflection.data;

import lombok.Getter;
import reflection.annotation.Invoke;

@Getter
public class SumClass {
    private int sum = 0;

    @Invoke
    public void plusOne() {
        sum += 1;
    }

    @Invoke
    public void plusTwo() {
        sum += 2;
    }

    @Invoke
    public void plusThree() {
        sum += 3;
    }
}
