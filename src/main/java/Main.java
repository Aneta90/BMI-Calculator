import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double weight = 0.0;
        while(weight <= 0.0){
            try{
                System.out.println("Type your weight");
                weight=scanner.nextDouble();
            } catch(InputMismatchException e){
                System.out.println("Wrong argument,try again!");
                scanner.nextDouble();
            }
        }
        double height = 0.0;
        while(height <= 0.0){
            System.out.println("Type your height");
            try{
                height=scanner.nextDouble();
            } catch(InputMismatchException e){
                System.out.println("Wrong argument,try again!");
                scanner.nextDouble();
            }
        }
        CalculateBMI calculateBMI = new CalculateBMI(weight,height);
        System.out.println(calculateBMI.interpret());

    }
}
