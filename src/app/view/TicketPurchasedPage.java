package app.view;

import java.io.IOException;
import java.io.Writer;

public class TicketPurchasedPage implements Page{

    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Ticket Purchased!</h1>\n");
        out.write("<h3>in developing</h3>\n");
        out.write("<p><a href='/'>Main page</a></p>\n");
        out.write("<p><a href='flights'>Back to flight list</a></p>\n");

        out.write("<hr>\n");
    }
}
