import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Skriv ett årtal:\n>> ");
        // Här behöver jag inte rensa resurerna manuellt, de ska hanteras per automatik när man skapar så
        try (Scanner årtalInput = new Scanner(System.in)) {
            int årtal = årtalInput.nextInt();
            // Här kollar vi om det är jämnt delbart annars är det inte ett skottår
            if ((årtal % 400 == 0 && årtal % 100 == 0) || (årtal % 4 == 0 && årtal % 100 != 0)) {
                System.out.println(årtal + " är ett skottår.");
            } else {
                System.out.println(årtal + " är inte ett skottår.");
            }
        }
    }
}
