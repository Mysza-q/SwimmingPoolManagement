import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        Pool pool = new Pool();

        while(shouldContinue) {
            System.out.println("Wybierz opcję");
            System.out.println("1. Wyświetl wszystkich klientów");
            System.out.println("2. Dodaj klienta");
            System.out.println("3. Dodaj wizytę");
            System.out.println("4. Zakup karnet");
            System.out.println("5. Wyświetl pozostały czas");
            System.out.println("6. Zwrot opaski");
            System.out.println("7. Sprawdź ilość karnetów");
            System.out.println("8. Znajdź po numerze telefonu");
            System.out.println("9. Wyjście");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1 -> pool.displayCLients();
                case 2 -> pool.addClient();
                case 3 -> pool.addTicket();
                case 4 -> pool.addPass();
                case 5 -> pool.calcEndTime();
                case 6 -> pool.returnBand();
                case 7 -> pool.countPass();
                case 8 -> pool.displayClientByPhoneNumber();
                case 9 -> shouldContinue = false;
            }

        }
    }
}