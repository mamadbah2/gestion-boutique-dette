package com.sheet.data.repositories.interfaces;

import com.sheet.core.repository.interfaces.Repository;
import com.sheet.data.entities.Client;

public interface ClientInterf extends Repository<Client> {
    public Client getClient(String name) ;
}
