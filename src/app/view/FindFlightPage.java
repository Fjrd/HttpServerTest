package app.view;

import app.model.Flight;

import java.io.IOException;
import java.io.Writer;

public class FindFlightPage implements Page {
    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Flight list from");
        out.write("  ");
        out.write(" to ");
        out.write("</h1>\n");

        out.write("<p><a href='/'>Main page</a></p>\n");
        out.write("<p><a href='purchased'>Buy a ticket</a></p>\n");
        out.write("<hr>\n");
    }
}
