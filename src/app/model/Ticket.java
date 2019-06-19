package app.model;


public class Ticket {
    private String passengerName;
    private int seat;
    private int cost;

    public Ticket(String passengerName, int seat) {
        this.passengerName = passengerName;
        this.seat = seat;
    }

    @Override
    public String toString() {

        return "has a ticket";
    }
}
