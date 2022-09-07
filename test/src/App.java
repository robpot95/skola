import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    // Skapa en Map med själva ordet som nyckel och ledtråd som värde
    static final HashMap<String, String> ord = new HashMap<String, String>();
    static {
        ord.put("hund", "Ett husdjur som skäller woof woof");
        ord.put("bil", "Ett färdmedel som tar dig från punkt a till b");
        ord.put("hus", "Du bor i ett");
    };

    public static void main(String[] args) throws Exception {
        List<String> rättGissningar = new ArrayList<>();
        List<String> felGissningar = new ArrayList<>();
        int liv = 7;

        // Här genererar vi ett slumpmässig ord från Mappen, dock måste vi först omvandla nycklara till en List
        // Sedan kör vi random.nextInt och tar storleken på listan med orden och slumpar själva ledtråden och sparar ordet i slumpOrd
        List<String> keys = new ArrayList<String>(ord.keySet());
        String slumpOrd = keys.get(new Random().nextInt(keys.size()));
        System.out.println(ord.get(slumpOrd));

        // Här lägger vi in ___ i listan för att få det e.x h_n_
        for (int i = 0; i < slumpOrd.length(); i++) {
            rättGissningar.add("_");
        }

        Scanner userInput = new Scanner(System.in);
        while (true) {
            // Fortsätt spela om vi har fortfarande liv
            if (liv == 0) {
                System.out.println("Gubben blev hängd :(");
                break;
            }

            System.out.print("Skriv in en bokstav:\n>> ");
            String gissat = userInput.nextLine();

            // Kolla om de användarna har skrivit in, är inte tomt och är max 1 bokstav
            if (!gissat.isEmpty() && gissat.length() == 1) {
                // Om ordet finns i slumpOrd, innebär det är rätt gissat. Då lägger vi in det i listan med rättGissningar
                // Om vi har redan gissat på ordet, så meddelar vi spelaren
                if (slumpOrd.contains(gissat)) {
                    if (rättGissningar.contains(gissat)) {
                        System.out.println("Du har redan gissat på bokstaven: " + gissat);
                    } else {
                        // Vi lägger in det rätta gisningen i rätt index, genom använda indexOf får vi veta vilken position
                        rättGissningar.set(slumpOrd.indexOf(gissat), gissat);
                    }
                } else {
                    // Om ordet är inte rätt och finns i felGissningar meddela spelaren
                    // Annars lägger vi in ordet i felGissningar och tar bort 1 liv
                    if (felGissningar.contains(gissat)) {
                        System.out.println("Du har redan gissat på bokstaven: " + gissat);
                    } else {
                        felGissningar.add(gissat);
                        liv--;
                    }
                }

                // Här visar vi spelaren: liv, rätta gissningar och fel gissningar
                System.out.format("Liv: %d\nRätt: %s\nFel: %s\n", liv, String.join("", rättGissningar), String.join(", ", felGissningar));

                // Nu kollar vi om slumpOrdet stämmer överens med våra rättaGissningar
                // Vi använder join för att slå ihop en lista med bokstäver
                if (slumpOrd.equals(String.join("", rättGissningar))) {
                    System.out.println("Grattis du vann, ordet var: " + slumpOrd);
                    break;
                }
            } else {
                System.out.println("Du kan gissa minst och max 1 bokstav åt gången.");
            }
        }


        userInput.close();
    }
}
