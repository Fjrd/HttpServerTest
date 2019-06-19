package app.utils;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class HttpUtils {

    public static HashMap<String, String> getForm(HttpExchange httpExchange) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody(), "UTF-8"));
        String text = readText(input);

        HashMap<String, String> form = new HashMap<>();
        for (String pair : text.split("&")) {
            int eqIndex = pair.indexOf('=');
            String name = pair.substring(0, eqIndex);
            String encodedValue = pair.substring(eqIndex + 1);
            String value = decodeParam(encodedValue);

            form.put(name, value);
        }
        return form;
    }

    private static String decodeParam(String encodedValue) throws UnsupportedEncodingException {
        return URLDecoder.decode(encodedValue, "UTF-8");
    }

    public static String readText(BufferedReader input) throws IOException {
        StringBuilder text = new StringBuilder();
        while (true) {
            int ch = input.read();
            if (ch == -1) break;
            text.append((char)ch);
        }
        return text.toString();
    }
}
