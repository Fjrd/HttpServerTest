package app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Flight {
    private Country from;
    private Country to;
    private LocalDateTime date;
    private int seatCounter = 0;
    private Map<String, Ticket> tickets = new HashMap<>();


    public Flight(Country from, Country to, LocalDateTime date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public Flight(String from, String to, String date) {
        this.from = Country.valueOf(from);
        this.to = Country.valueOf(to);
        this.date = convertStringToLocalDateTime(date);
    }

    public LocalDateTime convertStringToLocalDateTime(String string){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy H:m");
        LocalDateTime dateTime = LocalDateTime.parse(string, formatter);
        return dateTime;
    }

    public String convertLocalDateTimeToString(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(localDateTime);
    }


    public String generateTicketID() {
        return UUID.randomUUID().toString();
    }

    public Ticket findTicketById(String ticketId){
        return tickets.get(ticketId);
    }

    public int getSeatCounter() {
        return seatCounter;
    }

    public void incrementSeatCounter(){
        seatCounter++;
    }

    public Country getFrom() {
        return from;
    }

    public Country getTo() {
        return to;
    }

    public String getDate() {
        return convertLocalDateTimeToString(date);
    }

    @Override
    public String toString() {
        return from.getHumanFriendlyName()
                + " - "
                + to.getHumanFriendlyName()
                + ", "
                + convertLocalDateTimeToString(date);
    }
}