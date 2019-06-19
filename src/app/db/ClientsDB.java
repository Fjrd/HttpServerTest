package app.db;

import app.model.Client;
import app.model.Names;

import java.util.*;

public class ClientsDB extends DB{
    private Map<String, Client> clientsMap = new HashMap<>();

    public boolean addClient(Client client) {
        if (clientsMap.containsKey(client.getLogin())){
            return false;
        }
        else {
            clientsMap.put(client.getLogin(), client);
            return true;
        }
    }

    public Client findClientByLogin(String login) {
        return clientsMap.get(login);
    }

    public void fillClientsDBWithRandom() {
        for (int i=0; i<10; i++){
            addClient(new Client(randomLogin(), Names.randomFirstName(), Names.randomLastName()));
        }
    }

    public String randomLogin(){
        String[] temp = new Random().toString().split("@");
        return temp[1];
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clientsMap.values());
    }

}
