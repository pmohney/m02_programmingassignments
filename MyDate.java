// 11/4/23
// Pierce Mohney
// SDEV 200
// Assignment 2-1
// This program will convert milliseconds into a date added to the starting date of Jan. 1st 1970. The program will also show the 
//elapsed milliseconds since the current date from Jan. 1st 1970. 

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class MyDate {
    private int year;
    private int month;
    private int day;
//Sets classes of year day and month

    public MyDate(long elapsedSince1970) {
        setDate(elapsedSince1970);
    }
//Constructs time elapsed since Jan 1st 1970

    public MyDate() {
        setDate(System.currentTimeMillis());
    }
//Constructs current time

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
//Constructs a mydate object 

    public int getYear() {
        return year;
    }
//Gets the year from mydate

    public int getMonth() {
        return month;
    }
//Gets the month from mydate

    public int getDay() {
        return day;
    }
//Gets the day from mydate

    public void setDate(long elapsedTime) {
        Instant instant = Instant.ofEpochMilli(elapsedTime);
        LocalDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
//Finds elapsed time from current date from Jan. 1st 1970

        this.year = dateTime.getYear();
        this.month = dateTime.getMonthValue();
        this.day = dateTime.getDayOfMonth();
    }

    public long getElapsedSince1970() {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0);
        Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
        return instant.toEpochMilli();
    }
// Calculates elapsed time from current date from Jan. 1st 1970

    public static void main(String[] args) {
        MyDate currentDate = new MyDate(34355555133101L);
        System.out.println("34355555133101: " + currentDate.getYear() + "-" + currentDate.getMonth() + "-" + currentDate.getDay());
//Creates mydate object of 34355555133101

        MyDate customDate = new MyDate(561555550000L);
        System.out.println("561555550000: " + customDate.getYear() + "-" + customDate.getMonth() + "-" + customDate.getDay());
//Creates a mydate object of 561555550000

        MyDate customDate2 = new MyDate(2023, 11, 4);
        long elapsedTimeSince1970 = customDate2.getElapsedSince1970();
        System.out.println("Elapsed time since 1970: " + elapsedTimeSince1970 + " milliseconds");
//Creates a mydate object of the current date
    }
}
