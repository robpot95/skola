import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class App {
    // Vi använder oss av LinkedHasMap ist för HashMap, då vi bryr oss om ordningen av nycklarna
    static final LinkedHashMap<String, Integer> nivåMap = new LinkedHashMap<String, Integer>();
    static {
        nivåMap.put("lätt", 10);
        nivåMap.put("mellan", 100);
        nivåMap.put("svårt", 1000);
    };

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        try {
            System.out.print("Välj vilken nivå: ");
            for (String nivå : nivåMap.keySet()) {
                System.out.print(nivå + ", ");
            }

            System.out.print("\n>> ");
            String valdNivå = userInput.nextLine();
            // Här generar vi slumpmässig tal baserat på vilken nivå som är vald
            int randomNumber = new Random().nextInt(nivåMap.getOrDefault(valdNivå, 10)) + 1;
            System.out.print("Skriv in ett nummer:\n>> ");

            int försök = 0;
            while (true) {
                int gissning = userInput.nextInt();
                userInput.nextLine();
                if (gissning > randomNumber) {
                    System.out.print("Fel! Gissa lägre\n>> ");
                } else {
                    System.out.print("Fel! Gissa högre\n>> ");
                }

                försök += 1;
<<<<<<< HEAD
                if (gissning == randomNumber) {
=======
                if (nummerInput.nextInt() == randomNumber) {
>>>>>>> 07f92b7be2e87dd1018357075d81fc8336d57922
                    System.out.println(String.format("%d är rätt. Det tog dig %d försök att gissa rätt.", randomNumber, försök));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            userInput.close();
        }
    }
}