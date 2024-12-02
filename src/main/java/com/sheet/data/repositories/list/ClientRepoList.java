package com.sheet.data.repositories.list;

import java.util.ArrayList;
import java.util.List;

import com.sheet.data.entities.Client;
import com.sheet.data.repositories.ListImpl;
import com.sheet.data.repositories.interfaces.ClientInterf;

public class ClientRepoList extends ListImpl<Client> implements ClientInterf {
    private List<Client> clients = new ArrayList<Client>();

    public ClientRepoList() {
        clients.add(new Client("client1", "client1@gmail.com", "7785", "address1"));
        clients.add(new Client("client2", "client2@gmail.com", "8547", "address2"));
        clients.add(new Client("client3", "client3@gmail.com", "1245", "address3"));
        clients.add(new Client("client4", "client4@gmail.com", "9658", "address4"));
    }


    public Client getClient(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

}
