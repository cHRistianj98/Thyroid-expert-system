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
    private static boolean hithy = false;
    private static boolean borthy = false;
    private static boolean vhthy = false;
    private static boolean northy = false;
    private static boolean lothy = false;
    private static boolean discthy = false;
    private static boolean ht3t4_utsh = false;
    private static boolean e2_mtsh = false;
    private static boolean ht3_lt4 = false;
    private static boolean ovulatory = false;
    private static boolean pregnant = false;
    private static boolean sick = false;
    // true - man, false - woman
    private static boolean sex = false;

    private static int age = -1;

    private static TSH tsh;
    private static T3 t3;
    private static T4U t4U;
    private static FT4 ft4;
    private static FTI fti;
    private static TBG tbg;
    private static TT4 tt4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoją płeć (true - mann, false - woman):");
        sex = scanner.nextBoolean();

        System.out.println("Podaj swój wiek");
        age = scanner.nextInt();

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

        hithy();
        borthy();
        vhthy();
        northy();
        lothy();
        discthy();
        ht3t4_utsh();
        ht3_lt4();
        e2_mtsh();
        ovulatory();
        pregnant();
        sick();
        StringBuilder diagnosis = diagnosis();
        System.out.println(diagnosis);

    }

    private static StringBuilder diagnosis() {
        StringBuilder diagnosis = new StringBuilder();

        if (t3.getT3State().equals(State.HIGH)
                && hithy
                && tsh.getTshState().equals(State.MISSING)
                && (!tbg.getTbgState().equals(State.HIGH) && !t4U.getT4uState().equals(State.HIGH))) {
            diagnosis.append("T3 i THY są podwyższone zgodnie z tyreotoksykozą.\n");
        }
        if (t3.getT3State().equals(State.HIGH)
                && hithy
                && tsh.getTshState().equals(State.MISSING)
                && (tbg.getTbgState().equals(State.HIGH) || t4U.getT4uState().equals(State.HIGH))) {
            diagnosis.append("T3 i THY są podwyższone zgodnie z tyreotoksykozą i podwyższonym " +
                    "poziomem białka wiążącego. \n");
        }

        if (tsh.getTshState().equals(State.LOW)
                && t3.getT3State().equals(State.HIGH)
                && fti.getFtiState().equals(State.HIGH)
                && tt4.getTt4State().equals(State.NORMAL)) {
            diagnosis.append("Podwyższone FTI i T3, obniżone TSH zgodne z tyreotoksykozą. \n");
        }

        if (t3.getT3State().equals(State.HIGH)
                && hithy && tsh.getTshState().equals(State.HIGH)
                && !t4U.getT4uState().equals(State.HIGH)) {
            diagnosis.append("Podwyższone T3, THY i TSH zgodne z opornością obwodową lub wtórną nadczynnością tarczycy. \n");
        }

        return diagnosis;
    }

    private static void sick() {
        if (age > 70) {
            sick = true;
        }
    }

    private static void pregnant() {
        if (((age > 13 && age < 48) || age == 0) && ovulatory) {
            pregnant = true;
        }
    }

    private static void ovulatory() {
        if (((age > 13 && age < 48) || age == 0) && !sex) {
            ovulatory = true;
        }
    }

    private static void borthy() {
        if (fti.getFtiState().equals(State.HIGH) && tt4.getTt4State().equals(State.HIGH)) {
            borthy = true;
        }
    }

    private static void vhthy() {
        if (ft4.getFt4State().equals(State.HIGH) || fti.getFtiState().equals(State.HIGH)) {
            vhthy = true;
        }
    }

    private static void northy() {
        if (ft4.getFt4State().equals(State.MISSING) &&
                ((fti.getFtiState().equals(State.NORMAL) && tt4.getTt4State().equals(State.NORMAL))
                || (fti.getFtiState().equals(State.NORMAL))
                || (fti.getFtiState().equals(State.NORMAL) && tt4.getTt4State().equals(State.MISSING))
                || (fti.getFtiState().equals(State.MISSING) && tt4.getTt4State().equals(State.NORMAL)))) {
            northy = true;
        }
        if (fti.getFtiState().equals(State.MISSING) &&
                ((ft4.getFt4State().equals(State.NORMAL) && tt4.getTt4State().equals(State.NORMAL))
                || ft4.getFt4State().equals(State.NORMAL) && tt4.getTt4State().equals(State.MISSING)
                || ft4.getFt4State().equals(State.MISSING) && ft4.getFt4State().equals(State.NORMAL))) {
            northy = true;
        }
    }

    private static void hithy() {
        if (ft4.getFt4State().equals(State.MISSING) &&
                ((fti.getFtiState().equals(State.HIGH) && tt4.getTt4State().equals(State.HIGH))
                || (fti.getFtiState().equals(State.HIGH) && tt4.getTt4State().equals(State.MISSING))
                || (fti.getFtiState().equals(State.MISSING) && tt4.getTt4State().equals(State.HIGH)))) {
            hithy = true;
        }
        if (fti.getFtiState().equals(State.MISSING) &&
                ((ft4.getFt4State().equals(State.HIGH) && tt4.getTt4State().equals(State.HIGH))
                || (ft4.getFt4State().equals(State.HIGH) && tt4.getTt4State().equals(State.MISSING))
                || (ft4.getFt4State().equals(State.MISSING) && tt4.getTt4State().equals(State.HIGH)))) {
            hithy = true;
        }
    }

    private static void ht3t4_utsh() {
        if (t3.getT3State().equals(State.HIGH) && hithy && tsh.getTshState().equals(State.LOW)) {
            ht3t4_utsh = true;
        }
    }

    private static void ht3_lt4() {
        if (t3.getT3State().equals(State.HIGH) && lothy && tsh.getTshState().equals(State.LOW)) {
            ht3_lt4 = true;
        }
    }

    private static void e2_mtsh() {
        if (t3.getT3State().equals(State.HIGH) && northy && tsh.getTshState().equals(State.MISSING)) {
            e2_mtsh = true;
        }
    }

    private static void lothy() {
        if (ft4.getFt4State().equals(State.MISSING) &&
                ((fti.getFtiState().equals(State.LOW) && tt4.getTt4State().equals(State.LOW))
                || (fti.getFtiState().equals(State.LOW) && tt4.getTt4State().equals(State.MISSING))
                || (fti.getFtiState().equals(State.MISSING) && tt4.getTt4State().equals(State.LOW)))) {
            lothy = true;
        }
        if (fti.getFtiState().equals(State.MISSING) &&
                ((ft4.getFt4State().equals(State.LOW) && tt4.getTt4State().equals(State.LOW))
                || (ft4.getFt4State().equals(State.LOW) && tt4.getTt4State().equals(State.MISSING))
                || (ft4.getFt4State().equals(State.MISSING) && tt4.getTt4State().equals(State.LOW)))) {
            lothy = true;
        }
    }

    private static void discthy() {
        if (ft4.getFt4State().equals(State.MISSING) &&
                (t4U.getT4uState().equals(State.HIGH) || fti.getFtiState().equals(State.NORMAL))
                && tt4.getTt4State().equals(State.HIGH)) {
            discthy = true;
        }
    }

}
