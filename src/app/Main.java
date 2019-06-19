package app;

import app.db.ClientsDB;
import app.db.DB;
import app.db.FlightsDB;
import app.model.Client;
import app.model.Country;
import app.model.Flight;
import app.view.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.util.HashMap;

import static app.utils.HttpUtils.getForm;

public class Main {
    public static void main(String[] args) throws Exception {
        FlightsDB flightsDB = new FlightsDB();
        flightsDB.fillFlightDBWithRandom();
        ClientsDB clientsDB = new ClientsDB();
        clientsDB.fillClientsDBWithRandom();
        clientsDB.addClient(new Client("admin", "Admin", "Admin"));
        MyHandler myHandler = new MyHandler(clientsDB, flightsDB);


        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 1000);
        server.createContext("/", myHandler);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        private ClientsDB clientsDB;
        private FlightsDB flightsDB;

        public MyHandler(ClientsDB clientsDB, FlightsDB flightsDB) {
            this.clientsDB = clientsDB;
            this.flightsDB = flightsDB;
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String path = httpExchange.getRequestURI().getPath();
            String[] pathComponents = path.split("/");
            String firstComponent = "";

            if (pathComponents.length >= 1) {
                firstComponent = pathComponents[1];
            }
            switch (firstComponent) {
                case "":
                    respond(new MainPage(), httpExchange);
                    break;

                case "clients":
                    respond(new ClientsListPage(clientsDB.getAllClients()), httpExchange);
                    break;

                case "flights":
                    respond(new FlightsListPage(flightsDB.getAllFlights()), httpExchange);
                    break;

                case "profile":
                    clientProfile(httpExchange, path, clientsDB);
                    break;

                case "purchased":
                    respond(new TicketPurchasedPage(), httpExchange);
                    break;

                case "addflight":
                    if (httpExchange.getRequestMethod().toLowerCase().equals("post")) {
                        processAddForm(httpExchange, flightsDB);
                    } else {
                        respond(new AddFlightFormPage(), httpExchange);
                    }
                    break;

                case "addclient":
                    if (httpExchange.getRequestMethod().toLowerCase().equals("post")) {
                        processAddForm(httpExchange, clientsDB);
                    } else {
                        respond(new AddClientFormPage(), httpExchange);
                    }
                    break;

                default:
                    respondNotFound(httpExchange);
            }

            String response = "This is the response";
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    private static void respond(Page page, HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, 0);
        Writer out = new OutputStreamWriter(httpExchange.getResponseBody(), "UTF-8");
        page.generate(out);
        out.close();
    }

    private static void respondNotFound(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(404, 0);
        Writer out = new OutputStreamWriter(httpExchange.getResponseBody());
        out.write("<h1>Not found</h1>");
        out.close();
    }

    private static void processAddForm(HttpExchange httpExchange, DB db) throws IOException {
        HashMap<String, String> form = getForm(httpExchange);
        if (db instanceof ClientsDB){
            ClientsDB clientsDB = (ClientsDB) db;
            Client newClient = new Client(form.get("login"), form.get("firstname"), form.get("lastname"));
            boolean added = clientsDB.addClient(newClient);
            respond(new AddClientFormResultPage(newClient.getLogin(), added), httpExchange);
        }
        if (db instanceof FlightsDB){
            FlightsDB flightsDB = (FlightsDB) db;
            String from = form.get("from");
            String to = form.get("to");
            String date = form.get("day") + "-" + form.get("month") + "-" + form.get("year") + " " + form.get("hour") + ":" + form.get("minute");
            Flight newFlight = new Flight(from, to, date);
            boolean added = flightsDB.addFlight(newFlight);
            respond(new AddFlightFormResultPage(), httpExchange);
        }
    }

    private static void clientProfile(HttpExchange httpExchange, String path, ClientsDB clientsDB) throws IOException {
        String login = path.substring("/profile/".length());
        Client client = clientsDB.findClientByLogin(login);
        if (client == null) {
            respondNotFound(httpExchange);
        } else {
            respond(new ProfilePage(client), httpExchange);
        }
    }

}
