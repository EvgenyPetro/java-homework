package Homework2;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(pow(3, 2));
        System.out.println(pow(2, -2));
        System.out.println(pow(3, 0));
//        System.out.println(pow(0, 0));


        writeInFile(openFile("output.txt"), pow(11, 3));

        List<String> strings = readFile(openFile("input.txt"));
        int[] ints = parseString(strings);
        System.out.println(pow(ints[0], ints[1]));
    }

    static double pow(int a, int b) {
        if (a == 0) {
            System.out.println("Не определено");
            System.exit(-1);
            throw new RuntimeException();
        } else if (b > 1) {
            return positivePow(a, b);
        } else if (b < -1) {
            return negativePow(a, b);
        } else {
            return 1;
        }
    }

    static void writeInFile(Path file, double pow) {

        try {
            Files.write(file, String.valueOf(pow).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static List<String> readFile(Path file) {
        try {
            return Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] parseString(List<String> strings) {
        int[] intArr = new int[2];
        for (String string : strings) {
            String[] split = string.split(" ");
            if (split[0].equals("b")) {
                intArr[1] = Integer.parseInt(split[1]);
            } else if (split[0].equals("a")) {
                intArr[0] = Integer.parseInt(split[1]);
            }
        }
        return intArr;
    }

    private static Path openFile(String fileName) {
        Path path = Paths.get("Homework2/" + fileName);
        return path;
    }

    private static double negativePow(int a, int b) {
        double result = 1;
        for (int i = 0; i < b * -1; i++) {
            result *= a;
        }
        return 1 / result;
    }

    private static double positivePow(int a, int b) {
        double result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}
