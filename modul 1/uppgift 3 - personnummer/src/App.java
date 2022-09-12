<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 07f92b7be2e87dd1018357075d81fc8336d57922
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
<<<<<<< HEAD
    static final List<String> dagar = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
=======
    static final ArrayList<String> dagar = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"));
>>>>>>> 07f92b7be2e87dd1018357075d81fc8336d57922
    static final HashMap<String, List<String>> månader = new HashMap<String, List<String>>() {{
        put("01", dagar);
        put("02", dagar.subList(0, 28));
        put("03", dagar);
        put("04", dagar.subList(0, 30));
        put("05", dagar);
        put("06", dagar.subList(0, 30));
        put("07", dagar);
        put("08", dagar);
        put("09", dagar.subList(0, 30));
        put("10", dagar);
        put("11", dagar.subList(0, 30));
        put("12", dagar);
    }};

    public static void main(String[] args) throws Exception {
        try (Scanner userInput = new Scanner(System.in)) {
<<<<<<< HEAD
            System.out.print("Skriv in ditt personnummer:\n>> ");
            if (verfieraPersonnummer(userInput.nextLine())) {
                System.out.print("Godkänt");
            } else {
                System.out.print("Icke Godkänt");
            }
         }
=======
            System.out.print("Skriv in ditt personnummer: \n>> ");
            if (verfieraPersonnummer (userInput.nextLine())) {
                System.out.print("Godkänt"); 
            } else {
                System.out.print("Icke Godkänt");
            }
        }
>>>>>>> 07f92b7be2e87dd1018357075d81fc8336d57922
    }

    private static Boolean verfieraPersonnummer(String personnummer) {
        if (personnummer.isEmpty()) {
            return false;
        }

<<<<<<< HEAD
        // String fyraSista = personnummer.split("-")[1]; Om man vill få ut de 4 sista enkelt
        // Vi kan även använda oss av stringbuilder för att ta bort "-" via index. Vilket är mycket snabbare än replace
        personnummer = personnummer.replace("-", "");
        int personnummerLängd = personnummer.length();

        if (personnummerLängd < 10 || personnummerLängd > 13) {
=======
        /*
        String fyraSista = personnummer.split("-") [1]; Om man vill få ut de 4 sista enkelt 
        Vi kan även använda oss av stringbuilder för att ta bort "-" via index. Vilket är mycket snabbare än replace
        */
        personnummer = personnummer.replace("-", "");
        int personnummerLängd = personnummer.length();

        if (personnummerLängd < 10 | personnummerLängd > 13) {
>>>>>>> 07f92b7be2e87dd1018357075d81fc8336d57922
            System.out.println("Felaktig personnummer format, Kom ihåg att det ska vara 10 eller 12 siffrig");
            return false;
        }

        // Om personnummret är längre än 10, då vet vi att de är 12 siffrig
        int diffLängd = personnummerLängd > 10 ? 0 : 2;
<<<<<<< HEAD

=======
>>>>>>> 07f92b7be2e87dd1018357075d81fc8336d57922
        String år = personnummer.substring(0, 4 - diffLängd);
        String månad = personnummer.substring(4 - diffLängd, 6 - diffLängd);
        String dag = personnummer.substring(6 - diffLängd, 8 - diffLängd);
        String fyraSista = personnummer.substring(8 - diffLängd, 12 - diffLängd);

        // Kolla om månaden finns med i vår HashMap, sedan kolla om dagen finns med också. Exempelvis Feburari har 28 dagar
        if (!månader.containsKey(månad)) {
            System.out.println("Fel månad");
            return false;
<<<<<<< HEAD
        } else if (!månader.get(månad).contains(dag)) {
=======
        } else if (!månader.get(månad).contains (dag)) {
>>>>>>> 07f92b7be2e87dd1018357075d81fc8336d57922
            System.out.println("Fel dag");
            return false;
        }

        // Räkna ut om det är en kille eller tjej. Näst sista siffran om den är udda är det man och jämn är kvinna
<<<<<<< HEAD
        String kön = Integer.parseInt(fyraSista.substring(2, 3)) % 2 == 0 ? "Kvinna" : "Man";
        System.out.format("%s%s%s%s - %s - ", år, månad, dag,fyraSista, kön);
        return true;
    }
}
=======
        String kön = Integer.parseInt(fyraSista.substring(2, 3)) % 2 == 0 ? "Kvinna" : "Man"; System.out.format("%s%s%s% - % - ", år, månad, dag, fyraSista, kön);
        return true;
    }
}
>>>>>>> 07f92b7be2e87dd1018357075d81fc8336d57922
