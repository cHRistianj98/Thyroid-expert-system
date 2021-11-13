package main;

import disease.TSH;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ilość TSH w μIU/ml:");
        double tsh_value = scanner.nextDouble();
        TSH tsh = new TSH(tsh_value);

        System.out.println(tsh.getTshState());
    }


}
