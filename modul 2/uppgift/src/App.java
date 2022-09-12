import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner userInput = new Scanner(System.in)) {
            while (true) {
                System.out.print("Vad vill du göra?\n1. Addera två tal\n2. Räkna bokstäver i en sträng\n3. Spegelvänd en sträng\n4. Summera alla tal i en sträng\n>> ");
                if (userInput.hasNext()) {
                    if (userInput.hasNextInt()) {
                        switch (userInput.nextInt()) {
                            case 1:
                            addera(userInput);
                            break;
                            case 2:
                            dubbletter(userInput);
                            break;
                            case 3:
                            spegelvänd(userInput);
                            break;
                            case 4:
                            summera(userInput);
                            break;
                            default:
                            System.out.println("Alternativet finns inte.");
                            break;
                        }
                    } else {
                        if (userInput.nextLine().equals("e")) {
                            System.out.println("Hejdå.");
                            break;
                        }
                    }
                }
            }
            
        }
    }

private static void addera(Scanner userInput) {
    userInput.nextLine();

    int[] tal = new int[2];
    System.out.print("Första talet: ");
    tal[0] = userInput.nextInt();
    System.out.print("Andra talet: ");
    tal[1] = userInput.nextInt();
    System.out.println(tal[0] + tal[1]);

}

    private static void dubbletter(Scanner userInput) {
        userInput.nextLine();

        System.out.print("Ange ordet du vill leta i: ");
        String ord = userInput.nextLine();
        System.out.print("Ange bokstaven du vill leta efter: ");
        char bokstav = userInput.nextLine().charAt(0);

        int antal = 0;
        for (int i = 0; i < ord.length(); i++)
        {
            if (ord.charAt(i) == bokstav)
            {
                antal++;
            }
        }

        System.out.format("Det finns %dx %s i ordet %s.\n", antal, bokstav, ord);
    }

    private static void spegelvänd(Scanner userInput) {
        userInput.nextLine();

        // Annat sätt är att använda sig av StringBuilder och sedan köra reverse
        /* StringBuilder stringBuilder = new StringBuilder(userInput)
         * System.out.println(stringBuilder.reverse().toString());
        */

        System.out.print("Skriv in en sträng: ");
        String sträng = userInput.nextLine();

        String spegelvänt = "";
        for(int i = sträng.length() - 1; i >= 0; i--) {
            spegelvänt += sträng.charAt(i);
        }

        System.out.println(spegelvänt);
    }

    private static void summera(Scanner userInput) {
        userInput.nextLine();

        System.out.print("Skriv in en sträng med siffror och separera med kommatecken: ");
        String[] siffror = userInput.nextLine().split("[ ,]+");

        int totalt = 0;
        for (String siffra : siffror) {
            totalt += Integer.parseInt(siffra);
        }

        System.out.println("Det summerade värdet blir: " + totalt);
    }
}