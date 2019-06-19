package app.model;

public class Admin extends User {
    public Admin(String login, String firstName, String lastName, boolean isAdmin) {
        super(login, firstName, lastName, isAdmin);
    }
}
