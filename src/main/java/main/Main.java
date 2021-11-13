package main;

import disease.FT4;
import disease.FTI;
import disease.T3;
import disease.T4U;
import disease.TBG;
import disease.TSH;
import disease.TT4;
import enums.State;

import java.util.Scanner;

public class Main {
    private boolean hithy = false;

    private static TSH tsh;
    private static T3 t3;
    private static T4U t4U;
    private static FT4 ft4;
    private static FTI fti;
    private static TBG tbg;
    private static TT4 tt4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ilość TSH w μIU/ml:");
        double tsh_value = scanner.nextDouble();
        tsh = new TSH(tsh_value);

        System.out.println("Podaj ilość T3 w pg/mL:");
        double t3_value = scanner.nextDouble();
        t3 = new T3(tsh_value);

        System.out.println("Podaj ilość T3:");
        double fti_value = scanner.nextDouble();
        fti = new FTI(tsh_value);

        System.out.println("Podaj ilość TT4:");
        double tt4_value = scanner.nextDouble();
        tt4 = new TT4(tsh_value);

        StringBuilder diagnosis = new StringBuilder();

    }

    private void hithy() {
        if (ft4.getFt4State().equals(State.MISSING)
                && ((fti.getFtiState().equals(State.HIGH) && tt4.getTt4State().equals(State.HIGH))
                || (fti.getFtiState().equals(State.HIGH) && tt4.getTt4State().equals(State.MISSING))
                || (fti.getFtiState().equals(State.MISSING) && tt4.getTt4State().equals(State.HIGH)))) {
            hithy = true;
        }
     //linia 406
    }


}
