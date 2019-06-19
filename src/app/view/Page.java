package app.view;

import java.io.IOException;
import java.io.Writer;

public interface Page {
    void generate (Writer out) throws IOException;
}
