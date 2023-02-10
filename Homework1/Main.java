//+Написать программу вычисления n-ого треугольного числа.
package Homework1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = inputDigitN();
        int number = findNumber(n);
        printNumber(number);

    }


    public static int inputDigitN() {
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        String stringValue = scanner.next();
        return Integer.parseInt(stringValue);
    }

    public static int findNumber(int n) {
        return ((n + 1) * n) / 2;
    }

    public static void printNumber(int number) {
        System.out.println("n-е треугольное число: " + number);
    }
}
