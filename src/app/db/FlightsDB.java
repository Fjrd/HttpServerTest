package app.db;

import app.model.Country;
import app.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FlightsDB extends DB {
    private Map<String, Flight> flightDB = new HashMap<>();

    public boolean addFlight(Flight flight) {
        String flightID = generateFlightID();
        flightDB.put(flightID, flight);
        flightDB.get(flightID).generateTicketID();
        return true;
    }

    public List<Flight> getAllFlights(){
        return new ArrayList<>(flightDB.values());
    }

    public Flight findFlightById(int id){
        return  flightDB.get(id);
    }

    private String generateFlightID() {
        return UUID.randomUUID().toString();
    }

    public void fillFlightDBWithRandom() {
        for (int i=0; i<10; i++){
            long minDay = LocalDateTime.of(2019, 6, 20, 0, 0).toEpochSecond(ZoneOffset.UTC);
            long maxDay = LocalDateTime.of(2019, 6, 28, 23, 59).toEpochSecond(ZoneOffset.UTC);
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDateTime randomDateTime = LocalDateTime.ofEpochSecond(randomDay, 0, ZoneOffset.UTC);
            addFlight(new Flight(Country.randomCountry(), Country.randomCountry(), randomDateTime));
        }
    }
}
