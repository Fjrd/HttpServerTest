package app.view;

import java.io.IOException;
import java.io.Writer;

public class AddFlightFormResultPage implements Page {
    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Flight added!</h1>\n");
        out.write("<p><a href='/flights'>back to flights</a></p>\n");
    }
}
