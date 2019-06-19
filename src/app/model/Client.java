package app.model;

public class Client extends User{

    private Ticket ticket;

    public Client(String login, String firstName, String lastName) {
        super(login, firstName, lastName);
    }

    public String getTicket() {
        if (ticket == null)
            return "has no tickets";
        return ticket.toString();
    }

    public boolean buyTicket(Flight flight){
        if (flight.getSeatCounter() < 100){
            Ticket newTicket = new Ticket(getFirstAndLastName(), flight.getSeatCounter());
            flight.incrementSeatCounter();
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        if (ticket == null)
            return getLogin() + " " + getFirstAndLastName() + ", has no ticket.";
        return getLogin() + " " + getFirstAndLastName() + ", " + getTicket();
    }
}
