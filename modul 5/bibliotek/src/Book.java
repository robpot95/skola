import java.time.LocalDate;
import java.time.Month;

enum BookStatus {
    INGET,
    TILLGÄNLIG,
    LÅNAD
  }

public class Book {
    private String namn = "";
    private String författare = "";
    private LocalDate datum = LocalDate.of(1970, Month.JANUARY, 1);
    private String upplaga = "";
    private BookStatus status = BookStatus.INGET;

    public Book(String namn, String författare, LocalDate datum, String upplaga) {
        this.namn = namn;
        this.författare = författare;
        this.datum = datum;
        this.upplaga = upplaga;
        this.status = BookStatus.TILLGÄNLIG;
    }

    public String getNamn() {
        return namn;
    }

    public String getFörfattare() {
        return författare;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getUpplaga() {
        return upplaga;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String toString() {
        return String.format("Namn: %s\nFörfattare: %s\nÅr: %s\nUpplaga: %s\nStatus: %s", namn, författare, datum, upplaga, status);
    }
}
