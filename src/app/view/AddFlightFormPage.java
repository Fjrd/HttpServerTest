package app.view;

import app.model.Country;

import java.io.IOException;
import java.io.Writer;

public class AddFlightFormPage implements Page {
    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Add new flight</h1>\n");
        out.write("<form method='post' action='/addflight'>\n");

        //From
        out.write("<p>From: <select name='from'>\n");
        for (Country country : Country.values()) {
            out.write("  <option value='" +
                    country.name() + "'>" +
                    country.name() +
                    "</option>\n"
            );
        }
        out.write("</p></select>\n");

        //To
        out.write("<p>To: <select name='to'>\n");
        for (Country country : Country.values()) {
            out.write("  <option value='" +
                    country.name() + "'>" +
                    country.name() +
                    "</option>\n"
            );
        }
        out.write("</p></select>\n");

        //Day
        out.write("<p>Day: <select name='day'>\n");
        for (int i=1; i<=31; i++) {
            out.write("  <option value='" + i + "'>" + i + "</option>\n");
        }
        out.write("</p></select>\n");

        //Month
        out.write("<p>Month: <select name='month'>\n");
        for (int i=1; i<=12; i++) {
            out.write("  <option value='" + i + "'>" + i + "</option>\n");
        }
        out.write("</p></select>\n");

        //Year
        out.write("<p>Year: <select name='year'>\n");
        for (int i=2019; i<=2022; i++) {
            out.write("  <option value='" + i + "'>" + i + "</option>\n");
        }
        out.write("</p></select>\n");

        //Hour
        out.write("<p>Hour: <select name='hour'>\n");
        for (int i=0; i<=24; i++) {
            out.write("  <option value='" + i + "'>" + i + "</option>\n");
        }
        out.write("</p></select>\n");

        //Minute
        out.write("<p>Minute: <select name='minute'>\n");
        for (int i=0; i<=60; i++) {
            out.write("  <option value='" + i + "'>" + i + "</option>\n");
        }
        out.write("</p></select>\n");

        out.write("<p><input type='submit'></p>");
        out.write("</form>\n");
    }
}
