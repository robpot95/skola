import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Här skapar vi vår Maskin objekt och lägger till produkter
        Library library = new Library();
        library.addBook("Fire & Blood", "George R. R. Martin", LocalDate.of(2018, Month.NOVEMBER, 20), "Okänt");
        library.addBook("Harry Potter and the Philosopher's Stone", "J. K. Rowling", LocalDate.of(1997, Month.JUNE, 26), "Första Upplaga");
        library.addBook("Divergent", "Veronica Roth", LocalDate.of(2011, Month.APRIL, 26), "Första Upplaga");

        System.out.println("Välkommen till Roberto's bibliotek:");

        // Vi frågar hur mycket mynt användaren vill stoppa in i maskinen
        try (Scanner userInput = new Scanner(System.in)) {
            while (true) {
                System.out.print("1. Add a book to the library\n2. Search for a book by name\n3. List all available books\n4. Return a book\n5. Quit\n>> ");
                if (userInput.hasNext()) {
                    if (userInput.hasNextInt()) {
                        switch (userInput.nextInt()) {
                            case 1:
                                altOne(library, userInput);
                            break;
                            case 2:
                                altTwo(library, userInput);
                            break;
                            case 3:
                                library.showAvailableBooks();
                            break;
                            case 4:
                                altFour(library, userInput);
                            break;
                            case 5:
                                System.out.println("Tack för att du kom förbi.");
                                System.exit(0);
                            break;
                            default:
                                System.out.println("Alternativet finns inte.");
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void altOne(Library library, Scanner userInput) {
        userInput.nextLine();
                                
        System.out.print("Namn på booken? ");
        String namn = userInput.nextLine();
        System.out.print("Författare? ");
        String författare = userInput.nextLine();
        System.out.print("Vilken datum publicerades boken?(ÅÅÅ-MM-DD) ");
        String datum = userInput.nextLine();
        System.out.print("Upplaga? ");
        String upplaga = userInput.nextLine();

        library.addBook(namn, författare, LocalDate.parse(datum), upplaga);
        System.out.println("Nu har vi lagt in boken in i systemet.");
    }

    private static void altTwo(Library library, Scanner userInput) {
        userInput.nextLine();

        System.out.print("Vilken bok vill du söka efter? ");
        String namn = userInput.nextLine().toLowerCase();
        Book book = library.findBookByName(namn);
        if (book != null) {
            System.out.print("1. Vill du låna boken (J/N): ");
            String svar = userInput.nextLine().toLowerCase();
            if (svar.equals("j")) {
                if (library.loan(namn)) {
                    System.out.println("Nu har du lånat boken. Tack för lånet.");
                } else {
                    System.out.println("Boken är inte tillgänlig.");
                }
            }
        } else {
            System.out.println("Boken finns inte med i systemet.");
        }
    }

    private static void altFour(Library library, Scanner userInput) {
        userInput.nextLine();

        System.out.print("Vilken bok vill du lämna tillbaka? ");
        String namn = userInput.nextLine().toLowerCase();
        if (library.returnBook(namn)) {
            System.out.println("Nu är boken återlämnat. Tack för ditt lån.");
        } else {
            System.out.println("Du har inte lånat denna bok.");
        }
    }
}