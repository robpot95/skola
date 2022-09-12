import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> library = new ArrayList<Book>();

    public void addBook(String namn, String författare, LocalDate datum, String upplaga) {
        library.add(new Book(namn, författare, datum, upplaga));
    }

    public Book findBookByName(String name) {
        for (Book book : library) {
            if (name.equals(book.getNamn().toLowerCase())) {
                return book;
            }
        }

        return null;
    }

    public Boolean loan(String name) {
        final Book book = findBookByName(name);
        if (book.getStatus() == BookStatus.TILLGÄNLIG) {
            book.setStatus(BookStatus.LÅNAD);
            return true;
        }

        return false;
    }

    public Boolean returnBook(String name) {
        final Book book = findBookByName(name);
        if (book.getStatus() == BookStatus.LÅNAD) {
            book.setStatus(BookStatus.TILLGÄNLIG);
            return true;
        }
        
        return false;
    }

    public void showAllBooks() {
        for (Book book : library) {
            System.out.println(book.toString());
        }
    }

    public void showAvailableBooks() {
        for (Book book : library) {
            if (book.getStatus() == BookStatus.TILLGÄNLIG) {
                System.out.println(book.toString());
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return library;
    }
}
