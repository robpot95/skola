import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Här skapar vi vår Maskin objekt och lägger till produkter
        Machine machine = new Machine();
        machine.addProduct("cola", 10);
        machine.addProduct("kexchoklad", 15);
        machine.addProduct("festis", 8);
        machine.addProduct("chips", 13);

        // Här visar vi vilka produkter det finns i vår maskin
        machine.showProducts();

        // Vi frågar hur mycket mynt användaren vill stoppa in i maskinen
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.print("Hur mycket pengar vill du stoppa in?\n>> ");
            machine.addMoney(userInput.nextInt());
            userInput.nextLine();
            
            // Här Loopar vi så länge användaren har mynt kvar i maskinen eller tills de kör 'e' för exit
            while (machine.getMoney() != 0) {
                System.out.print("Skriv vilken produkt du vill köpa:\n>> ");
                String choice = userInput.nextLine().toLowerCase();
                if (choice.equals("e")) {
                    break;
                }

                if (machine.buyProduct(choice)) {
                    System.out.println("Tack för ditt köp. Du har " + machine.getMoney() + "kr kvar.");
                }

                System.out.println(choice);
            }
        }
    }
}
