package com.sheet.data.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;

import com.sheet.data.entities.Client;
import com.sheet.data.repositories.interfaces.ClientInterf;

import java.util.List;

public class ClientRepoJPA implements ClientInterf {

    @PersistenceContext
    private EntityManager em;

    

    public ClientRepoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Client client) {
        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Client client) {
        try {
            em.getTransaction().begin();
            Client managedClient = em.merge(client); // Assure que le client est géré par le contexte de persistance
            em.remove(managedClient);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAll() {
        try {
            return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client getClient(String name) {
        try {
            return em.find(Client.class, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(List<Client> object) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public Client convertToObject(ResultSet rs) {
        throw new UnsupportedOperationException("Method convertToObject not supported with JPA");
    }
}


