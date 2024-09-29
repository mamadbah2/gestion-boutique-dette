package com.sheet.data.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sheet.data.entities.Dette;
import com.sheet.data.repositories.interfaces.DetteInterf;

import java.util.List;
import java.sql.ResultSet;


public class DetteRepoJPA implements DetteInterf {

    @PersistenceContext
    private EntityManager em;

    public DetteRepoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Dette dette) {
        try {
            em.getTransaction().begin();
            em.persist(dette);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Dette dette) {
        try {
            em.getTransaction().begin();
            Dette managedDette = em.merge(dette); // Assure que l'entité est gérée par le contexte de persistance
            em.remove(managedDette);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Dette> getAll() {
        try {
            return em.createQuery("SELECT d FROM Dette d", Dette.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Dette getDette(String date) {
        try {
            return em.createQuery("SELECT d FROM Dette d WHERE d.date = :date", Dette.class)
                     .setParameter("date", date)
                     .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(List<Dette> object) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public Dette convertToObject(ResultSet rs) {
        throw new UnsupportedOperationException("Method convertToObject not supported with JPA");
    }
}
