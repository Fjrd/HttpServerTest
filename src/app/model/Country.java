package app.model;

import java.util.List;
import java.util.Random;

public enum Country {
    USA("Usa"),
    RUSSIA ("Russia"),
    GERMANY("Germany"),
    FRANCE("France"),
    ITALY("Italy"),
    CHINA("China");

    private String humanFriendlyName;

    Country(String humanFriendlyName) {
        this.humanFriendlyName = humanFriendlyName;
    }

    public String getHumanFriendlyName() {
        return humanFriendlyName;
    }


    public static Country randomCountry() {
        Random random = new Random();
        int index = random.nextInt(Country.values().length);
        return Country.values()[index];
    }
}
