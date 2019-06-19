package app.view;

import app.model.Country;

import java.io.IOException;
import java.io.Writer;

public class MainPage implements Page {
    Country[] countries = Country.values();
    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Main Page</h1>\n");
        out.write("<hr>\n");
        out.write("<p><a href='/flights'>Flights</a></p>\n");
        out.write("<p><a href='/clients'>Clients</a></p>\n");
        out.write("<hr>\n");
    }
}
