import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "A";
        } else if (number % 3 == 0) {
            return "T";
        } else if (number % 5 == 0) {
            return "Q";

        } else return "fff";
    }

    @Test
    public void checkIfatBothNumber() {
        String actualResult = trialCode(90);
        assertEquals(actualResult, "A", "Ожидалось другое значение");
    }

    @Test
    public void checkIfatTreeNumber() {
        String actualResult = trialCode(12);
        assertEquals(actualResult, "T", "Ожидалось другое значение");
    }

    @Test
    public void checkIfatFiveNumber() {
        String actualResult = trialCode(100);
        assertEquals(actualResult, "Q", "Ожидалось другое значение");
    }
}
