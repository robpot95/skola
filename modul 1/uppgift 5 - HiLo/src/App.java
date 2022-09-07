import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class App {
    // Vi använder oss av LinkedHasMap ist för HashMap, då vi bryr oss om ordningen av nycklarna
    static final Map<String, Integer> nivåMap = new LinkedHashMap<String, Integer>();
    static {
        nivåMap.put("lätt", 10);
        nivåMap.put("mellan", 100);
        nivåMap.put("svårt", 1000);
    };

    public static void main(String[] args) {
        Scanner nivåInput = new Scanner(System.in);
        Scanner nummerInput = new Scanner(System.in);
        try {
            System.out.print("Välj vilken nivå: ");
            for (String nivå : nivåMap.keySet()) {
                System.out.print(nivå + ", ");
            }

            System.out.print("\n>> ");
            String valdNivå = nivåInput.nextLine();
            Random random = new Random();
            int randomNumber = random.nextInt(nivåMap.getOrDefault(valdNivå, 10)) + 1;
            System.out.print("Skriv in ett nummer:\n>> ");

            int försök = 1;
            while (true) {
                if (nummerInput.nextInt() > randomNumber) {
                    System.out.print("Fel! Gissa lägre\n>> ");
                } else {
                    System.out.print("Fel! Gissa högre\n>> ");
                }

                försök += 1;
                if (nummerInput.nextInt() == randomNumber) {
                    System.out.println(String.format("%d är rätt. Det tog dig %d försök att gissa rätt.", randomNumber, försök));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            nivåInput.close();
            nummerInput.close();
        }
    }
}