import java.time.LocalDate;
import java.time.LocalDateTime;

public class Expense {

    //Private Klassen
    private int id;
    private String beschreibung;
    private double betrag;
    private LocalDate date;
    private String kategorie;
    private LocalDateTime timestamp;

    //Konstruktor
    public Expense(int id, String beschreibung, double betrag, LocalDate date, String kategorie) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.betrag = betrag;
        this.date = date;
        this.kategorie = kategorie;
        this.timestamp = LocalDateTime.now();
    }

    //Getter Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
