package app.view;

import java.io.IOException;
import java.io.Writer;

public class AddClientFormPage implements Page{
    @Override
    public void generate(Writer out) throws IOException {
        out.write("<h1>Add new client</h1>\n");
        out.write("<form method='post' action='/addclient'>\n");
        out.write("<p>Login: <input type='text' name='login'></p>");
        out.write("<p>First name: <input type='text' name='firstname'></p>");
        out.write("<p>Last name: <input type='text' name='lastname'></p>");
        out.write("<p><input type='submit'></p>");
        out.write("</form>\n");
    }
}
