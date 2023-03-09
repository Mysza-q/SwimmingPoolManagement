import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Pass extends Ticket {

    private int counter=30;


    public Pass(int idTicket, int idClient, LocalTime timeNow, int paidTime) {
        super(idTicket, idClient, timeNow, paidTime);
    }

    public Pass() {

    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    public void usePass(){
        if (this.counter>0){
            this.counter--;
        }
        else {
            System.out.println("Karnet został wykorzystany.");
        }

    }

}
