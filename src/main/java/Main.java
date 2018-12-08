import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your weight");
        double weight= scanner.nextDouble();
        System.out.println("Type your height");
        double height = scanner.nextDouble();
        CalculateBMI calculateBMI = new CalculateBMI(weight,height);
        System.out.println(calculateBMI.interpretBMI());


    }
}
