package app.view;

import app.model.Client;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class ClientsListPage implements Page{
    private List<Client> clients;

    public ClientsListPage(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Clients List</h1>\n");

        out.write("<p><a href='/'>back to main page</a></p>\n");
        out.write("<p><a href='/addclient'>add new client</a></p>\n");


        out.write("<hr>\n");

        for (Client client : clients) {
            out.write("<p>");
            out.write("<a href='/profile/" + client.getLogin() + "'>");
            out.write(client.getFirstAndLastName());
            //out.write(client.toString());
            out.write("</a>");
            out.write("</p>\n");
        }
    }


}
