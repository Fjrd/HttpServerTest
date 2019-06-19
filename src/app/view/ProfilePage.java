package app.view;

import app.model.Client;

import java.io.IOException;
import java.io.Writer;

public class ProfilePage implements Page {
    private Client client;

    public ProfilePage(Client client) {
        this.client = client;
    }

    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Profile for " + client.getLogin() + "</h1>\n");
        out.write("<p><a href='/'>back to main page</a></p>\n");
        out.write("<p><a href='/clients'>back to client list</a></p>\n");

        out.write("<p>Login: " + client.getLogin() + "</p>\n");
        out.write("<p>First name: " + client.getFirstName() + "</p>\n");
        out.write("<p>Last name: " + client.getLastName() + "</p>\n");
        out.write("<p>Is admin: " + client.isAdmin() + "</p>\n");
        out.write("<p>Tickets: " + client.getTicket() + "</p>\n");

        out.write("<hr>\n");
    }
}
