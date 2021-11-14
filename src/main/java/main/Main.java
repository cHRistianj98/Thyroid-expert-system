package main;

import examination.FT4;
import examination.FTI;
import examination.T3;
import examination.T4U;
import examination.TBG;
import examination.TSH;
import examination.TT4;
import enums.State;

import java.util.Scanner;

public class Main {
    private static boolean hithy = false;
    private static boolean vhthy = false;
    private static boolean northy = false;
    private static boolean lothy = false;
    private static boolean discthy = false;
    private static boolean ovulatory = false;
    private static boolean pregnant = false;
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

        System.out.println("Zastosuj się do instrukcji. Jeżeli badanie nie zostało wykonane wpisz 0");
        String sexQuestion = "Czy badany jest mężczyzną (true/false)?:";
        loadBooleanDataFromUser(scanner, sexQuestion);

        String ageQuestion = "Podaj wiek pacjenta (1-100):";
        loadIntegerDataFromUser(scanner, ageQuestion);

        String tshQuestion = "Podaj ilość TSH w μIU/ml (0-15):";
        tsh = new TSH(loadDoubleDataFromUser(scanner, tshQuestion));

        String t3Question = "Podaj ilość T3 w pg/mL (0-5):";
        t3 = new T3(loadDoubleDataFromUser(scanner, t3Question));

        String ftiQuestion = "Podaj ilość FTI (0-200):";
        fti = new FTI(loadDoubleDataFromUser(scanner, ftiQuestion));

        String tt4Question = "Podaj ilość TT4 (0-200):";
        tt4 = new TT4(loadDoubleDataFromUser(scanner, tt4Question));

        String t4uQuestion = "Podaj ilość T4U (0-2):";
        t4U = new T4U(loadDoubleDataFromUser(scanner, t4uQuestion));

        String ft4Question = "Podaj ilość FT4 (0-50):";
        ft4 = new FT4(loadDoubleDataFromUser(scanner, ft4Question));

        String tbgQuestion = "Podaj ilość TBG (0-50):";
        tbg = new TBG(loadDoubleDataFromUser(scanner, tbgQuestion));

        initializeAttributes();
        System.out.println(makeDiagnosis());
        scanner.close();
    }

    private static void loadBooleanDataFromUser(Scanner scanner, String question) {
        while (true) {
            try {
                System.out.println(question);
                sex = scanner.nextBoolean();
            } catch (Exception e) {
                System.out.println("Nieprawidłowe wejście. ");
                scanner.nextLine();
                continue;
            }
            break;
        }
    }

    private static void loadIntegerDataFromUser(Scanner scanner, String question) {
        while (true) {
            try {
                System.out.println(question);
                age = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Nieprawidłowa liczba całkowita. ");
                scanner.nextLine();
                continue;
            }
            break;
        }
    }

    private static double loadDoubleDataFromUser(Scanner scanner, String question) {
        while (true) {
            try {
                System.out.println(question);
                double number = scanner.nextDouble();
                return number;
            } catch (Exception e) {
                System.out.println("Nieprawidłowa liczba zmiennoprzecinkowa. ");
                scanner.nextLine();
            }
        }
    }
    
    private static void initializeAttributes() {
        hithy();
        vhthy();
        northy();
        lothy();
        discthy();
        ovulatory();
        pregnant();
    }

    private static StringBuilder makeDiagnosis() {
        StringBuilder diagnosis = new StringBuilder();

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
            diagnosis.append("Niskie THY. ");
            diagnosis.append("Zgodne z wtórną niedoczynnością tarczycy. \n");
        }

        if (lothy && tsh.getTshState().equals(State.NORMAL)) {
            diagnosis.append("Niski THY zgodny z chorym stanem eutyreozy. \n");
        }

        if (lothy && (t3.getT3State().equals(State.NORMAL))) {
            diagnosis.append("Niskie THY. ");
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
            diagnosis.append("Podwyższona terapia tyroksyną w T4. \n");
        }

        if (t3.getT3State().equals(State.LOW) && tsh.getTshState().equals(State.NORMAL) && fti.getFtiState().equals(State.HIGH)) {
            diagnosis.append("Niski T3, wysoki FTI, prawidłowe TSH zgodne z chorobą niezwiązaną z tarczycą i terapią T4. \n");
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
                && fti.getFtiState().equals(State.LOW)) {
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
                    "TSH wskazuje na wyrównaną niedoczynność tarczycy, a niski T4U wskazuje na niski poziom wiązania białka. \n");
        }

        if (t3.getT3State().equals(State.NORMAL) && tt4.getTt4State().equals(State.NORMAL)
                && fti.getFtiState().equals(State.HIGH)) {
            diagnosis.append("Niezgodne testy czynności tarczycy. Ten profil zgodny z interferencją leków.\n");
        }

        if (tsh.getTshState().equals(State.HIGH) && tt4.getTt4State().equals(State.HIGH)) {
            diagnosis.append("Wtórna nadczynność tarczycy, gruczolak przysadki wydzielający TSH.\n");
        }

        if (tsh.getTshState().equals(State.HIGH) && tt4.getTt4State().equals(State.NORMAL)) {
            diagnosis.append("Subkliniczna niedoczynność tarczycy.\n");
        }

        if (tsh.getTshState().equals(State.HIGH) && tt4.getTt4State().equals(State.LOW)) {
            diagnosis.append("Pierwotna niedoczynność tarczycy, autoimmunologiczne zapalenie tarczycy.\n");
        }

        if (tsh.getTshState().equals(State.NORMAL) && tt4.getTt4State().equals(State.HIGH)) {
            diagnosis.append("Wtórna nadczynność tarczycy, gruczolak przysadki wydzielający TSH.\n");
        }

        if (tsh.getTshState().equals(State.NORMAL) && tt4.getTt4State().equals(State.NORMAL)) {
            diagnosis.append("Na podstawie badań TSH oraz T4 pacjent ma zdrową tarczycę.\n");
        }

        if (tsh.getTshState().equals(State.NORMAL) && tt4.getTt4State().equals(State.LOW)) {
            diagnosis.append("Wtórna niedoczynność tarczycy, niewydzielniczy gruczolak przysadki.\n");
        }

        if (tsh.getTshState().equals(State.LOW) && tt4.getTt4State().equals(State.HIGH)) {
            diagnosis.append("Pierwotna nadczynność tarczycy, choroba Grave'a .\n");
        }

        if (tsh.getTshState().equals(State.LOW) && tt4.getTt4State().equals(State.HIGH)) {
            diagnosis.append("Pierwotna nadczynność tarczycy, choroba Grave'a .\n");
        }

        if (tsh.getTshState().equals(State.LOW) && tt4.getTt4State().equals(State.NORMAL)) {
            diagnosis.append("Subkliniczna nadczynność tarczycy lub toksykoza T3.\n");
        }

        if (tsh.getTshState().equals(State.LOW) && tt4.getTt4State().equals(State.LOW)) {
            diagnosis.append("Wtórna kliniczna niedoczynność tarczycy, niewydzielniczy gruczolak przysadki.\n");
        }

        if ((ft4.getFt4State().equals(State.NORMAL) || ft4.getFt4State().equals(State.MISSING))
                && (fti.getFtiState().equals(State.NORMAL) || fti.getFtiState().equals(State.MISSING))
                && (t3.getT3State().equals(State.NORMAL) || t3.getT3State().equals(State.MISSING))
                && (t4U.getT4uState().equals(State.NORMAL) || t4U.getT4uState().equals(State.MISSING))
                && (tbg.getTbgState().equals(State.NORMAL) || tbg.getTbgState().equals(State.MISSING))
                && (tsh.getTshState().equals(State.NORMAL) || tsh.getTshState().equals(State.MISSING))
                && (tt4.getTt4State().equals(State.NORMAL) || tt4.getTt4State().equals(State.MISSING))) {
            diagnosis.append("Wszystkie badania w normie, pacjent zdrowy.\n");
        }

        return diagnosis;
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
