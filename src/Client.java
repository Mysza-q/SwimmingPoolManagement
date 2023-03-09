public class Client {
    private int id;
    private static String name;
    private static int age;
    private static int phoneNumber;
    private static boolean havePass = false;
    private Pass pass;
    static int currentIdNumber = 0;

    public Client() {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Client(int idNum, String name, int age, int phoneNumber, boolean havePass) {
        currentIdNumber++;

        if(idNum==-1){
            id = currentIdNumber;
        }
        else
            id = idNum;

        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.havePass = havePass;
    }

    public void setHavePass(boolean havePass) {
        this.havePass = havePass;
    }

    public static String getName() {
        return name;
    }

    public static int getAge() {
        return age;
    }

    public static int getPhoneNumber() {
        return phoneNumber;
    }

    public static boolean HavePass() {
        return havePass;}

    public static void displayClientInformation(){
        System.out.println("Imię: "+ getName());
        System.out.println("Wiek: "+ getAge());
        System.out.println("Numer telefonu: "+ getPhoneNumber());
        String havePassString = HavePass() ? "tak" : "nie";
        System.out.println("Czy posiada karnet? "+havePassString);
    }
}
