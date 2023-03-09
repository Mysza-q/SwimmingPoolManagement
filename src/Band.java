import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.Scanner;

import static java.time.LocalTime.*;

public class Band{
    private static LocalTime endTime;
    private static LocalTime currentTime;
    private int bandID;

    private int lockerNumber;
    private static LocalTime leftTime;


    public int getBandID() {
        return bandID;
    }

    public void setBandID(int bandID) {
        this.bandID = bandID;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public void setLockerNumber(int lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }




}
