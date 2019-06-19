package app.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Names {
    static List<String> knownFirstNames = Arrays.asList("Daniel", "James", "Lucas", "Tom", "John");
    static List<String> knownLastNames = Arrays.asList(" Smith", "Williams", "Taylor", "Clark", "Green", "Turner", "Collins", "Robinson", "Anderson", "Harris");

    public static String randomFirstName() {
        int numberFirstName = new Random().nextInt(knownFirstNames.size());
        return knownFirstNames.get(numberFirstName);
    }
    public static String randomLastName() {
        int numberLastName = new Random().nextInt(knownLastNames.size());
        return knownLastNames.get(numberLastName);
    }

}

