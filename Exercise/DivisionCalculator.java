package Exercise;

import java.util.*;

public class DivisionCalculator {
    static Scanner sc = new Scanner(System.in);

    public static double divide(int numerator, int denominator) {
        try {
            return numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("Error: Cant Divide Zero");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter numerical number: ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter denominator number: ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.println(divide(num1, num2));

    }
}