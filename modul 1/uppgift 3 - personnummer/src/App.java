import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*final ArrayList<String> dagar = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"));
        final Map<String, List<String>> månader = new HashMap<String, List<String>>() {{
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
        }};*/

        Scanner input = new Scanner(System.in);
        System.out.println("Välj mellan lätt, mellan, svår");
        String input1 = input.nextLine();

        int nivå = 0;
        if (input1.equals("lätt")) {
            nivå = 10;
        } else if (input1.equals("mellan")) {
            nivå = 100;
        } else if (input1.equals("svår")) {
            nivå = 1000;
        }

        int randomNumber = new Random().nextInt(nivå) + 1;
        System.out.println("Skriv in ett nummer");
        int guess = input.nextInt();
        while (guess != randomNumber) {
            if (guess > randomNumber) {
                System.out.println("För högt");
            } else {
                System.out.println("För lågt");
            }
            System.out.println("Skriv in ett nytt nummer!");
            guess = input.nextInt();
        }

        System.out.println("Du har rätt!");
    }
}
