import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pool {
    private final List<Client> clients = new ArrayList<>();
    private final List<Ticket> tickets = new ArrayList<>();
    private final List<Pass> passes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public void addClient() {
        System.out.println("Podaj numer porzadkowy klienta");
        int id = scanner.nextInt();

        System.out.println("Podaj imię klienta");
        String name = scanner.nextLine();
        name = scanner.nextLine();

        System.out.println("Podaj wiek klienta");
        int age = Integer.valueOf(scanner.nextLine());

        System.out.println("Podaj numer telefonu");
        int phoneNumber = Integer.valueOf(scanner.nextLine());

        System.out.println("Czy posiada karnet? (Y/N)");
        String havePassString;
        havePassString = scanner.nextLine();

        boolean havePass;

        havePass = havePassString.equals("Y");

        Client client = new Client(id, name, age, phoneNumber, havePass);
        clients.add(client);

    }


    public void displayClientByPhoneNumber() {

        System.out.println("Podaj numer telefonu klienta");
        int phoneNumber = scanner.nextInt();
        Client client = new Client();
        boolean fl = false;

        for (int i = 0; i < clients.size(); i++) {
            client = clients.get(i);
            if(client.getPhoneNumber() == phoneNumber){
                fl = true;
                break;
            }
        }

        if (fl=false) {
            return;
        }

        System.out.println("Wyszukiwany klient to: ");
        client.displayClientInformation();

    }


    public void addTicket() {

        System.out.println("Podaj numer porzadkowy klienta");
        int clientId = scanner.nextInt();
        Client client = new Client();
        boolean fl = false;

        //przejscie po liscie i spr czy id klienta sie zgadza

        for (int i = 0; i < clients.size(); i++) {
            client = clients.get(i);
            if(client.getId() == clientId){
                fl = true;
                break;
            }
        }

        if (fl=false) {
        return;
        }

        if (!client.HavePass()) {

            System.out.println("Podaj numer biletu");
            int ticketId = scanner.nextInt();

            LocalTime beginTime = Ticket.getNow();

            System.out.println("Podaj opłacony czas pobytu w minutach");
            int paidTime = scanner.nextInt();

            Ticket ticket = new Ticket(ticketId, client.getId(), beginTime, paidTime);
            tickets.add(ticket);
        }
        else{
            System.out.println("Podaj numer karnetu");
            int passId = scanner.nextInt();
            Pass pass = new Pass();
            int x = 0;

            for (int i = 0; i < passes.size(); i++) {
                pass = passes.get(i);
                if(pass.getIdTicket() == passId){
                    fl = true;
                    x = i;
                    break;
                }

            }

            if (fl=false) {
                return;
            }
            pass.usePass();
            passes.set(x,pass);

        }
    }

    public void addPass(){
        System.out.println("Podaj numer porzadkowy klienta");
        int clientId = scanner.nextInt();
        Client client = new Client();
        boolean fl = false;

        for (int i = 0; i < clients.size(); i++) {
            client = clients.get(i);
            if(client.getId() == clientId){
                fl = true;
                Client.displayClientInformation();
                break;
            }
        }

        if (fl=false) {
            return;
        }

        System.out.println("Podaj numer karnetu");
        int passId = scanner.nextInt();
        LocalTime timeNow = LocalTime.now();
        int paidTime = 90;

        Pass pass = new Pass(passId, client.getId(), timeNow, paidTime);
        passes.add(pass);

    }

    public void countPass(){
        int ilosc = 0;
        for (Pass p: passes) {
            if(p.getCounter()>0){
                ilosc++;
            }
        }
        System.out.println("Liczba aktywnych karnetów wynosi: "+ilosc);
    }

    public Duration calcEndTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime beginTime = Ticket.getNow();
        int paidTime = Ticket.getPaidTime();
        int hour = beginTime.getHour();
        int minute = beginTime.getMinute();

        System.out.println("Podaj numer porzadkowy klienta");
        int clientId = scanner.nextInt();
        Client client = new Client();
        boolean fl = false;

        for (int i = 0; i < clients.size(); i++) {
            client = clients.get(i);
            if(client.getId() == clientId){
                fl = true;
                client.displayClientInformation();
                break;
            }
        }

        LocalTime endTime = beginTime.plusMinutes(paidTime);
        LocalTime currentTime = LocalTime.now();
        Duration diff = Duration.between(currentTime, endTime);
        endTime = LocalTime.parse(endTime.format(dtf));
        System.out.println("Twoj bilet straci ważność o:"+endTime+". \n Pozostało Ci: "+diff.toMinutes()+" minut.");
        return diff;
    }


    public void returnBand(){
        if (calcEndTime().toMinutes() >= 0)
        {
            System.out.println("Dziękujemy za wizytę!");
        }
        else {
            double doplata = (double) calcEndTime().toMinutes()*0.5 ;
            System.out.println("Proszę dopłacić "+doplata+" zł za przekroczony czas pobytu.");
        }
    }

    public void displayCLients(){
        for (Client c: clients) {
            c.displayClientInformation();
        }

    }

}
