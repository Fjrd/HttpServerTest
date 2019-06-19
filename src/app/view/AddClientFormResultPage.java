package app.view;

import java.io.IOException;
import java.io.Writer;

public class AddClientFormResultPage implements Page {
    private String login;
    private boolean added;

    public AddClientFormResultPage(String login, boolean added) {
        this.login = login;
        this.added = added;
    }

    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Client added!</h1>\n");
        out.write("<p><a href='/clients'>back to clients</a></p>\n");

        if (added) {
            out.write("<p>Client " + login + " added.</p>");
        } else {
            out.write("<p>Client " + login + " already exists.</p>");
        }
    }
}
