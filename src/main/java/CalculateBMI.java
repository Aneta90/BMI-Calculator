import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class CalculateBMI implements Calculator<String> {

    private double weight;
    private double height;

    public String calculate(double... params) throws IllegalArgumentException {

        double weight = params[0];
        double height = params[1];

        if(weight > 0.0 & height> 0.0) {
            double bmi = (weight / Math.pow(height / 100, 2));
            BigDecimal bmiBig = new BigDecimal(bmi);
            bmiBig = bmiBig.round(new MathContext(2));
            return bmiBig.toString();
        } else{
            throw new IllegalArgumentException();
        }
    }

    public String interpret(String bmi) {
        double[] bmiResult = {18.5,23.0,25.0};
        String[] labels = {"Underweight","Normal Range","At Risk", "Overweight"};

        double result = Double.parseDouble(bmi);
        int index= Math.abs(Arrays.binarySearch(bmiResult,result))-1;
        return labels[index];
    }

}
