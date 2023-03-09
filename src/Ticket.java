import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private int idTicket;
    private int idClient;
    private DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static LocalTime now;
    private static int paidTime;


    public Ticket(int idTicket, int idClient, LocalTime timeNow, int paidTime) {
        this.idTicket = idTicket;
        this.date = date;
        this.now = timeNow;
        this.paidTime = paidTime;
    }

    public Ticket() {

    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public DateTimeFormatter getDate() {
        return date;
    }

    public void setDate(DateTimeFormatter date) {
        this.date = date;
    }

    public static LocalTime getNow() {
        return now;
    }

    public static void setNow(LocalTime now) {
        Ticket.now = now;
    }

    public static int getPaidTime() {
        return paidTime;
    }

    public static void setPaidTime(int paidTime) {
        Ticket.paidTime = paidTime;
    }
}