package com.sheet.services;

import com.sheet.data.entities.Client;
import com.sheet.data.repositories.interfaces.ClientInterf;

public class ClientServ {
    private ClientInterf clientRepo;

    public ClientServ(ClientInterf clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client searchClient(String name) {
        return clientRepo.getClient(name);
    }
}
