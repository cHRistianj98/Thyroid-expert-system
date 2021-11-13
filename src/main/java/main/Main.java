package main;

import disease.FT4;
import disease.FTI;
import disease.T3;
import disease.T4U;
import disease.TBG;
import disease.TSH;
import disease.TT4;
import enums.State;
import org.w3c.dom.html.HTMLDOMImplementation;

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

        System.out.println("Czy jesteś mężczyzną (true/false)?:");
        sex = scanner.nextBoolean();

        System.out.println("Podaj swój wiek (1-100):");
        age = scanner.nextInt();

        System.out.println("Podaj ilość TSH w μIU/ml (0-15):");
        double tsh_value = scanner.nextDouble();
        tsh = new TSH(tsh_value);

        System.out.println("Podaj ilość T3 w pg/mL (0-5):");
        double t3_value = scanner.nextDouble();
        t3 = new T3(tsh_value);

        System.out.println("Podaj ilość FTI (0-200):");
        double fti_value = scanner.nextDouble();
        fti = new FTI(tsh_value);

        System.out.println("Podaj ilość TT4 (0-200):");
        double tt4_value = scanner.nextDouble();
        tt4 = new TT4(tsh_value);

        System.out.println("Podaj ilość T4U (0-2):");
        double t4u_value = scanner.nextDouble();
        t4U = new T4U(t4u_value);

        System.out.println("Podaj ilość FT4 (0-50):");
        double ft4_value = scanner.nextDouble();
        ft4 = new FT4(ft4_value);

        System.out.println("Podaj ilość TBG (0-50):");
        double tbg_value = scanner.nextDouble();
        tbg = new TBG(tbg_value);

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

        System.out.println(diagnosis());

    }

    private static StringBuilder diagnosis() {
        StringBuilder diagnosis = new StringBuilder();

        if (t3.getT3State().equals(State.HIGH)
                && hithy
                && (!tbg.getTbgState().equals(State.HIGH) && !t4U.getT4uState().equals(State.HIGH))) {
            diagnosis.append("T3 i THY są podwyższone zgodnie z tyreotoksykozą.\n");
        }
        if (t3.getT3State().equals(State.HIGH)
                && hithy
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

        if (t3.getT3State().equals(State.NORMAL)
                && (hithy || vhthy)
                && tsh.getTshState().equals(State.HIGH)
                && !t4U.getT4uState().equals(State.HIGH)) {
            diagnosis.append("Podwyższone THY i TSH, możliwa interferencja leków, oporność obwodowa lub wtórna nadczynność tarczycy. \n");
        }

        if (t3.getT3State().equals(State.HIGH)
                && (hithy || vhthy)
                && tsh.getTshState().equals(State.HIGH)
                && t4U.getT4uState().equals(State.HIGH)) {
            diagnosis.append("Podwyższone T3, THY i TSH zgodne z przeciwciałami, opornością obwodową lub wtórną nadczynnością tarczycy.\n");
        }

        if (t3.getT3State().equals(State.HIGH)
                && tt4.getTt4State().equals(State.HIGH)
                && fti.getFtiState().equals(State.NORMAL)
                && tsh.getTshState().equals(State.HIGH)
                && !pregnant) {
            diagnosis.append("Podwyższone T3,TT4 i TSH zgodne z przeciwciałami.\n");
        }

        if (lothy && (t3.getT3State().equals(State.NORMAL))) {
            diagnosis.append("Niskie THY. \n");
            diagnosis.append("zgodne z wtórną niedoczynnością tarczycy. \n");
        }

        if (lothy && tsh.getTshState().equals(State.NORMAL)) {
            diagnosis.append("Niski THY zgodny z chorym stanem eutyreozy. \n");
        }

        if (lothy && (t3.getT3State().equals(State.NORMAL))) {
            diagnosis.append("Niskie THY. \n");
            diagnosis.append("Rozpoznanie pierwotnej niedoczynności tarczycy zależy od TSH. \n");
        }

        if (t3.getT3State().equals(State.LOW)
                && (tsh.getTshState().equals(State.NORMAL) || tsh.getTshState().equals(State.LOW))) {
            diagnosis.append("T3 jest niski, co sugeruje chory stan eutyreozy. \n");
        }

        if (t3.getT3State().equals(State.LOW)) {
            diagnosis.append("Rozpoznanie niedoczynności tarczycy w niskim T3 zależy od TSH. \n");
        }

        if (tsh.getTshState().equals(State.LOW) && t3.getT3State().equals(State.LOW)
                && tt4.getTt4State().equals(State.HIGH)) {
            diagnosis.append("Ten profil zgodny z chorym stanem eutyreozy. \n");
        }

        if (t4U.getT4uState().equals(State.LOW) && tt4.getTt4State().equals(State.LOW)
                && fti.getFtiState().equals(State.NORMAL) && t3.getT3State().equals(State.LOW)
                && !tsh.getTshState().equals(State.HIGH)) {
            diagnosis.append("Niskie T4, T3 i T4U wskazujące na niskie wiązanie białka. \n");
        }

        if (t4U.getT4uState().equals(State.LOW) && tt4.getTt4State().equals(State.LOW)
                && !t3.getT3State().equals(State.LOW) && fti.getFtiState().equals(State.NORMAL)
                && !tsh.getTshState().equals(State.HIGH)) {
            diagnosis.append("Niskie T4 i T4U wskazujące na niskie wiązanie białka. \n");
        }

        if (t4U.getT4uState().equals(State.LOW) && t3.getT3State().equals(State.LOW)
                && fti.getFtiState().equals(State.HIGH) && tsh.getTshState().equals(State.NORMAL)) {
            diagnosis.append("Ten profil jest zgodny z chorym stanem eutyreozy z równoczesnym niskim wiązaniem białka. \n");
        }

        if (t4U.getT4uState().equals(State.LOW) && tt4.getTt4State().equals(State.LOW)
                && t3.getT3State().equals(State.LOW) && fti.getFtiState().equals(State.HIGH)) {
            diagnosis.append("Niskie T4, T3 i T4U wskazujące na niskie wiązanie białka. Podwyższona FTI z powodu terapii tyroksyną. \n");
        }

        if (t4U.getT4uState().equals(State.LOW) && tt4.getTt4State().equals(State.LOW)
                && fti.getFtiState().equals(State.HIGH)) {
            diagnosis.append("Niskie T4 i T4U wskazujące na niskie wiązanie białka. Podwyższona FTI z powodu terapii tyroksyną. \n");
        }

        if (tt4.getTt4State().equals(State.LOW) && !t4U.getT4uState().equals(State.LOW)
                && (ft4.getFt4State().equals(State.NORMAL) || fti.getFtiState().equals(State.NORMAL))
                && t3.getT3State().equals(State.NORMAL)
                && (tsh.getTshState().equals(State.NORMAL) || tsh.getTshState().equals(State.LOW))) {
            diagnosis.append("T4 jest niski. Zapytanie o białko o niskim poziomie wiązania. \n");
        }

        if (tbg.getTbgState().equals(State.HIGH)) {
            diagnosis.append("Podwyższone TBG. \n");
        }

        if (lothy && !t3.getT3State().equals(State.NORMAL)) {
            diagnosis.append("T3 i THY są niskie, zgodnie z chorym stanem eutyreozy. \n");
        }

        if (fti.getFtiState().equals(State.HIGH) && tt4.getTt4State().equals(State.NORMAL) && t4U.getT4uState().equals(State.NORMAL)) {
            diagnosis.append("Nieznacznie podwyższone FTI zgodne z leczeniem tyroksyną. \n");
        }

        if (t3.getT3State().equals(State.NORMAL) && tt4.getTt4State().equals(State.HIGH)
                && (!fti.getFtiState().equals(State.LOW) && !ft4.getFt4State().equals(State.LOW))) {
            diagnosis.append("Podwyższone T4 zgodne z lekami tyroksyny. \n");
        }

        if (discthy && !pregnant) {
            diagnosis.append("Eleveated T4 query thyroxine therapy. \n");
        }

        if (t3.getT3State().equals(State.LOW) && tsh.getTshState().equals(State.NORMAL) && fti.getFtiState().equals(State.HIGH)) {
            diagnosis.append("Low T3, high FTI, normal TSH consistent with non-thyroidal illness and t4 therapy. \n");
        }

        if (hithy && !vhthy) {
            diagnosis.append("Podwyższony FTI zgodny z zastępowaniem tyroksyny. \n");
        }

        if (!tt4.getTt4State().equals(State.LOW) && vhthy) {
            diagnosis.append("Podwyższony FTI zgodny z zastępowaniem tyroksyny. \n");
        }

        if (t3.getT3State().equals(State.HIGH) && t4U.getT4uState().equals(State.HIGH) && northy && pregnant) {
            diagnosis.append("Podwyższony T3 zgodny ze zwiększonym białkiem wiążącym. \n");
        }

        if (tsh.getTshState().equals(State.HIGH) && tt4.getTt4State().equals(State.NORMAL)
                && fti.getFtiState().equals(State.LOW) && t3.getT3State().equals(State.HIGH)) {
            diagnosis.append("Podwyższony T3 zgodny ze zwiększonym białkiem wiążącym. Podwyższony TSH i niski FTI sugerują wymianę. \n");
        }

        if (northy && t4U.getT4uState().equals(State.HIGH) && !tsh.getTshState().equals(State.HIGH)) {
            diagnosis.append("Podwyższone T4U zgodne ze zwiększonym białkiem wiążącym. \n");
        }

        if (t4U.getT4uState().equals(State.HIGH) && fti.getFtiState().equals(State.LOW)
                && tt4.getTt4State().equals(State.NORMAL) && !tsh.getTshState().equals(State.HIGH)) {
            diagnosis.append("Podwyższone T4U zgodne ze zwiększonym białkiem wiążącym. \n");
        }

        if (!t3.getT3State().equals(State.HIGH) && !tt4.getTt4State().equals(State.HIGH)
                && !t4U.getT4uState().equals(State.HIGH) && !tbg.getTbgState().equals(State.HIGH)) {
            diagnosis.append("Podwyższone T3 i T4 zgodne z tyreotoksykozą. \n");
        }

        if (discthy && pregnant) {
            diagnosis.append("Podwyższone T4 i T4U zgodne ze zwiększonym białkiem wiążącym. \n");
        }

        if (discthy && t3.getT3State().equals(State.HIGH) && tsh.getTshState().equals(State.HIGH)) {
            diagnosis.append("Podwyższone T4 i T3 zgodne ze zwiększonym białkiem wiążącym. Podwyższony TSH sugeruje niedostateczną wymianę. \n");
        }

        if (tsh.getTshState().equals(State.HIGH) && tt4.getTt4State().equals(State.NORMAL)
                && fti.getFtiState().equals(State.LOW) && !t3.getT3State().equals(State.HIGH)) {
            diagnosis.append("Podwyższone TSH i niski FTI zgodne z pierwotną niedoczynnością tarczycy. \n");
        }

        if (t3.getT3State().equals(State.LOW) && tt4.getTt4State().equals(State.LOW)
                && fti.getFtiState().equals(State.LOW) && !sick) {
            diagnosis.append("niski poziom hormonów tarczycy sugeruje niedoczynność tarczycy, do pełnej interpretacji wymaga TSH. \n");
        }

        if (lothy && t3.getT3State().equals(State.LOW) && tsh.getTshState().equals(State.LOW)) {
            diagnosis.append("Niskie hormony tarczycy bez podwyższonego TSH. zgodne z wtórną niedoczynnością tarczycy. \n");
        }

        if (t3.getT3State().equals(State.NORMAL) && tsh.getTshState().equals(State.HIGH)) {
            diagnosis.append("Prawidłowy T3 z podwyższonym TSH jest zgodny z wyrównaną niedoczynnością tarczycy. \n");
        }

        if (t3.getT3State().equals(State.NORMAL) && tsh.getTshState().equals(State.HIGH)) {
            diagnosis.append("Normalny T3. Nieznacznie podwyższone TSH sugeruje skompensowaną niedoczynność tarczycy. \n");
        }

        if (t3.getT3State().equals(State.NORMAL) && t4U.getT4uState().equals(State.LOW)) {
            diagnosis.append("Normalny T3 i niski T4 z podwyższonym TSH zgodnym z wyrównaną niedoczynnością tarczycy. \n");
        }

        if (tsh.getTshState().equals(State.HIGH) && tt4.getTt4State().equals(State.LOW)
                && t3.getT3State().equals(State.LOW) && fti.getFtiState().equals(State.NORMAL)
                && t4U.getT4uState().equals(State.NORMAL)) {
            diagnosis.append("Niski poziom T3 wskazuje na chorobę niezwiązaną z tarczycą, podwyższony " +
                    "TSH wskazuje na wyrównaną niedoczynność tarczycy, a niski T4U wskazuje na niski poziom wiązania białka . \n");
        }

        if (t3.getT3State().equals(State.NORMAL) && tt4.getTt4State().equals(State.NORMAL)
                && fti.getFtiState().equals(State.HIGH)) {
            diagnosis.append("Niezgodne testy czynności tarczycy. Ten profil zgodny z interferencją leków.\n");
        }

        if (ft4.getFt4State().equals(State.LOW)) {
            diagnosis.append("Niskie FT4.\n");
        }

        if (fti.getFtiState().equals(State.LOW)) {
            diagnosis.append("Niskie FTI.\n");
        }

        if (t3.getT3State().equals(State.LOW)) {
            diagnosis.append("Niskie T3.\n");
        }

        if (t4U.getT4uState().equals(State.LOW)) {
            diagnosis.append("Niskie T4U.\n");
        }

        if (tbg.getTbgState().equals(State.LOW)) {
            diagnosis.append("Niskie TBG.\n");
        }

        if (tsh.getTshState().equals(State.LOW)) {
            diagnosis.append("Niskie TSH.\n");
        }

        if (tt4.getTt4State().equals(State.LOW)) {
            diagnosis.append("Niskie TT4.\n");
        }

        if (ft4.getFt4State().equals(State.NORMAL)) {
            diagnosis.append("FT4 w normie.\n");
        }

        if (fti.getFtiState().equals(State.NORMAL)) {
            diagnosis.append("FTI w normie.\n");
        }

        if (t3.getT3State().equals(State.NORMAL)) {
            diagnosis.append("T3 w normie.\n");
        }

        if (t4U.getT4uState().equals(State.NORMAL)) {
            diagnosis.append("T4U w normie.\n");
        }

        if (tbg.getTbgState().equals(State.NORMAL)) {
            diagnosis.append("TBG w normie.\n");
        }

        if (tsh.getTshState().equals(State.NORMAL)) {
            diagnosis.append("TSH w normie.\n");
        }

        if (tt4.getTt4State().equals(State.NORMAL)) {
            diagnosis.append("TT4 w normie.\n");
        }

        if (ft4.getFt4State().equals(State.HIGH)) {
            diagnosis.append("Wysokie FT4.\n");
        }

        if (fti.getFtiState().equals(State.HIGH)) {
            diagnosis.append("Wysokie FTI.\n");
        }

        if (t3.getT3State().equals(State.HIGH)) {
            diagnosis.append("Wysokie T3.\n");
        }

        if (t4U.getT4uState().equals(State.HIGH)) {
            diagnosis.append("Wysokie T4U.\n");
        }

        if (tbg.getTbgState().equals(State.HIGH)) {
            diagnosis.append("Wysokie TBG.\n");
        }

        if (tsh.getTshState().equals(State.HIGH)) {
            diagnosis.append("Wysokie TSH.\n");
        }

        if (tt4.getTt4State().equals(State.HIGH)) {
            diagnosis.append("Wysokie TT4.\n");
        }

        return diagnosis;
    }

    private static void sick() {
        if (age > 70) {
            sick = true;
        }
    }

    private static void pregnant() {
        if ((age > 13 && age < 48) && ovulatory) {
            pregnant = true;
        }
    }

    private static void ovulatory() {
        if (age > 13 && age < 48 && !sex) {
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
        if (((fti.getFtiState().equals(State.NORMAL) && tt4.getTt4State().equals(State.NORMAL))
                || (fti.getFtiState().equals(State.NORMAL))
                || (tt4.getTt4State().equals(State.NORMAL)))) {
            northy = true;
        }
        if ((ft4.getFt4State().equals(State.NORMAL))) {
            northy = true;
        }
    }

    private static void hithy() {
        if (ft4.getFt4State().equals(State.MISSING) &&
                ((fti.getFtiState().equals(State.HIGH) && tt4.getTt4State().equals(State.HIGH))
                || (fti.getFtiState().equals(State.HIGH))
                || (tt4.getTt4State().equals(State.HIGH)))) {
            hithy = true;
        }
        if (((ft4.getFt4State().equals(State.HIGH) && tt4.getTt4State().equals(State.HIGH))
                || (ft4.getFt4State().equals(State.HIGH))
                || (tt4.getTt4State().equals(State.HIGH)))) {
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
        if (((fti.getFtiState().equals(State.LOW) && tt4.getTt4State().equals(State.LOW))
                || (fti.getFtiState().equals(State.LOW))
                || (tt4.getTt4State().equals(State.LOW)))) {
            lothy = true;
        }
        if (((ft4.getFt4State().equals(State.LOW) && tt4.getTt4State().equals(State.LOW))
                || (ft4.getFt4State().equals(State.LOW))
                || (tt4.getTt4State().equals(State.LOW)))) {
            lothy = true;
        }
    }

    private static void discthy() {
        if ((t4U.getT4uState().equals(State.HIGH) || fti.getFtiState().equals(State.NORMAL))
                && tt4.getTt4State().equals(State.HIGH)) {
            discthy = true;
        }
    }

}
