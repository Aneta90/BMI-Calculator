import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class CalculatorTest extends TestCase {

    CalculateBMI calculateBMI;

    @Before
    public void setUp() {
        calculateBMI = new CalculateBMI();
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "calcIllegalValues")
    public void testCalculateIllegalArgumentsBMI(double weight, double height) {
        calculateBMI.calculate(weight,height);
    }

    private Object[] calcIllegalValues() {
        return new Object[]{
                new Object[]{54.0, 0.0},
                new Object[]{-1.0, 160.0},
        };
    }

    @Test
    @Parameters(method = "calcLegalValues")
    public void testCalculateLegalAgrumentsBMI(double weight, double height, String expected) {
        assertEquals(calculateBMI.calculate(weight,height),expected);
    }

    private Object[] calcLegalValues() {
        return new Object[]{
                new Object[]{54.0, 160.0, "21"}
        };
    }

    @Test
    @Parameters(method="interpretResults")
    public void testInterpretationOfBMI(String bmi, String category){
        assertEquals(calculateBMI.interpret(bmi),category);
    }

    private Object[] interpretResults() {
        return new Object[]{
                new Object[]{"16.0","Underweight"},
                new Object[]{"21.0","Normal Range"},
                new Object[]{"26.0","Overweight"}
        };
    }

}
