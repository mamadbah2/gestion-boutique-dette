package com.sheet.data.repositories.interfaces;

import com.sheet.data.entities.Client;
import com.sheet.data.repositories.Repository;

public interface ClientInterf extends Repository<Client> {
    public Client getClient(String name) ;
}
