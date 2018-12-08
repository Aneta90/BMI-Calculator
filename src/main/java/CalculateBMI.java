import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class CalculateBMI implements Calculator {

    private double weight; //statyczna jak raz ją zmienie to się zmmieni wszędzie
    private double height;

    public CalculateBMI() {
    }

    public CalculateBMI(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Min. weight or min. height is 0");
        } else {
            this.weight = weight;
            this.height = height;
        }
    }

    public String calculateBMI() {

        double bmi = (weight / Math.pow(height, 2))*10000;
        BigDecimal bmiBig = new BigDecimal(bmi);
        bmiBig = bmiBig.round(new MathContext(2));
        return bmiBig.toString();

    }

    public String interpretBMI() {

        double[] bmiResult = {18.5,23.0,25.0};
        String[] labels = {"Underweight","Normal Range","At Risk", "Overweight"};

        double result = Double.parseDouble(calculateBMI());
        int index= Math.abs(Arrays.binarySearch(bmiResult,result))-1;
        return labels[index];

    }
}
