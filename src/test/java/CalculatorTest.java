import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class CalculatorTest extends TestCase {

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "calcIllegalValues")
    public void testCalculateIllegalArgumentsBMI(double weight, double height) {
        CalculateBMI calculateBMI = new CalculateBMI(weight, height);
    }

    private Object[] calcIllegalValues() {
        return new Object[]{
                new Object[]{54.0, 0.0},
                new Object[]{-1.0, 160.0},
        };
    }

    @Test
    @Parameters(method = "calcLegalValues")
    public void testCalculateLegalAgrumentsBMI(double weight, double height, double expectedValue) {
        CalculateBMI calculateBMI = new CalculateBMI(weight, height);
        assertEquals(expectedValue, Double.parseDouble(calculateBMI.calculate()),0.1);
    }

    private Object[] calcLegalValues() {
        return new Object[]{
                new Object[]{54.0, 160.0, 21.09}
        };
    }

    @Test
    @Parameters(method="interpretResults")
    public void testInterpretationOfBMI(double weight, double height, String category){
        CalculateBMI calculateBMI = new CalculateBMI(weight,height);
        assertEquals(calculateBMI.interpret(),category);
    }

    private Object[] interpretResults() {
        return new Object[]{
                new Object[]{25.0,160.0,"Underweight"},
                new Object[]{54.0,160.0,"Normal Range"},
                new Object[]{80.0,160.0,"Overweight"}
        };
    }

}
