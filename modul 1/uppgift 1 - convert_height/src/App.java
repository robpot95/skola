import java.util.HashMap;
import java.util.Scanner;

public class App {
    // Vi skapar en Map, med dom olika längdtyperna (key) och vad deras cm omvandlig (value)
    static final HashMap<String, Float> längdTyper = new HashMap<String, Float>();
    static {
        längdTyper.put("famnar", 178.0f);
        längdTyper.put("alnar", 59.4f);
        längdTyper.put("tum", 2.54f);
        längdTyper.put("fot", 30.48f);
    };

    public static void convertHeight(String längdTyp, int längd) {
        // Kör simpel matte gångra value med längd. Om längdtypen inte finns med som nyckel, landa tillbaka på 0f
        System.out.println(String.format("%d %s = %.1f cm", längd, längdTyp, längdTyper.getOrDefault(längdTyp, 0f) * längd));
    }

    public static void main(String[] args) throws Exception {
        // Loopar igenom nycklarna och visa dom i terminalen
        System.out.print("Välj vad du vill konvertera till cm: ");
        for (String längdTyp : längdTyper.keySet()) {
            System.out.print(längdTyp + ", ");
        }

        // Error-Handling: Användaren ska mata in värden som siffor, annars släng ut error.
        // Efter användaren matat in siffrorna, kör in dom i funktionen som konverterar
        // Ovasett om vi lyckas eller misslyckas, se till att rensa resurserna efter sig. (Annars kan man få memory-leak)
        System.out.print("\n>> ");
        Scanner userInput = new Scanner(System.in);
        try {
            String längdTyp = userInput.nextLine();

            System.out.print("Skriv in längden\n>> ");
            int längd = userInput.nextInt();
    
            convertHeight(längdTyp, längd);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            userInput.close();
        }
    }
}
