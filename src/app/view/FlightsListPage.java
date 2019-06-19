package app.view;

import app.model.Flight;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FlightsListPage implements Page{
    private List<Flight> flights;

    public FlightsListPage(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Flights List</h1>\n");

        out.write("<p><a href='/'>back to main page</a></p>\n");
        out.write("<p><a href='addflight'>Add new flight</a></p>\n");
        out.write("<p><a href='purchased'>Buy a ticket</a> in developing</p>\n");
        out.write("<hr>\n");

        out.write("<table style=\"width:100%\">\n" +
                "  <tr>" +
                "    <th>From</th>" +
                "    <th>To</th>" +
                "    <th>Date</th>" +
                "  </tr>");

        for (Flight flight : flights) {
            out.write("<tr>");
            out.write("<td align=\"center\"valign=\"middle\">");
            out.write(flight.getFrom().getHumanFriendlyName());
            out.write("</td>");
            out.write("<td align=\"center\" valign=\"middle\">");
            out.write(flight.getTo().getHumanFriendlyName());
            out.write("</td>");
            out.write("<td align=\"center\" valign=\"middle\">");
            out.write(flight.getDate());
            out.write("</td>");
            out.write("</tr>");
        }
    }
}
