import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Välkommen!! Här kan du göra massor");


        menyalternativ();
        System.out.println("Välj mella 1-4 alternative");

            while (true) {
                String vald1 = sc.nextLine();
                System.out.println("Vad vill du göra nu?");

                if (vald1.equals("1")) {
                    System.out.println("Här adderar vi två tal");
                    addera(sc);
                } else if (vald1.equals("2")) {
                    System.out.println("Här räkna vi bokstäver i en sträng");
                    bokStaver();
                } else if (vald1.equals("3")) {
                    System.out.println("Här spegelvänd en sträng");
                    spegelvänt();
                } else if (vald1.equals("4")) {
                    System.out.println("Här summera vi alla tal i en sträng");
                } else if (vald1.equals("e")) {
                    System.out.println("Hej då!");
                    break;
                }
            }


        
    }

    static void menyalternativ() {
        System.out.println("Vad vill du göra?");
        System.out.println("1.Addera två tal.");
        System.out.println("2.Räkna bokstäver i en sträng.");
        System.out.println("3.Spegelvänd en sträng");
        System.out.println("4.Summera alla tal i en sträng");
        System.out.println("e. Avsluta");
    }

    static void addera(Scanner sc) {
        System.out.print("Första talet: ");
        int tal1 = sc.nextInt();
        System.out.print("Andra talet: ");
        int tal2 = sc.nextInt();
        System.out.println(tal1 + tal2);
    }

    static void bokStaver() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ange ordet du vill leta i :");
            String word = scanner.nextLine();
            System.out.println("Ange bokstaven du vill leta efter:");
            char bokstav = scanner.nextLine().charAt(0);

            int antal = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == bokstav) { antal++;
                }
            }
          System.out.format("Det finns %d %s i word %s.\n", antal, bokstav, word);
        }
    }

    static void spegelvänt(){
       try (Scanner scanner = new Scanner(System.in)) {

           System.out.println("Skriv in en sträng");
           String sträng = scanner.nextLine();


           String spegelvänt = "";
           for (int i = sträng.length() - 1; i >= 0; i--) {
               spegelvänt = spegelvänt + sträng.charAt(i);
           }

           System.out.println(spegelvänt);
       }
    }
}