import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your weight");

        double weight = 0.0;
        while(weight <= 0.0){
            try{
                weight=scanner.nextDouble();
                if(weight<=0.0){
                    System.out.println("Wrong argument,try again!");
                }
            } catch(InputMismatchException e){
                System.out.println("Wrong argument, try again!");
                scanner.nextDouble();
            }
        }

        System.out.println("Type your height");
        double height = 0.0;
        while(height <= 0.0){
            try{
                height=scanner.nextDouble();
                if(height<=0.0){
                    System.out.println("Wrong argument,try again!");
                }
            } catch(InputMismatchException e){
                System.out.println("Wrong argument, try again!");
                scanner.nextDouble();
            }
        }
        CalculateBMI calculateBMI = new CalculateBMI();
        String bmi = calculateBMI.calculate(weight,height);
        String result = calculateBMI.interpret(bmi);
        System.out.println("Your BMI is " + bmi + ".You are " + result);
    }
}
