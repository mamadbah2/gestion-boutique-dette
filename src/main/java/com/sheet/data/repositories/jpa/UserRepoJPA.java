package com.sheet.data.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sheet.data.entities.User;
import com.sheet.data.repositories.interfaces.UserInterf;

import java.util.List;
import java.sql.ResultSet;

public class UserRepoJPA implements UserInterf {

    @PersistenceContext
    private EntityManager em;

    public UserRepoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) {
        try {
            em.getTransaction().begin();
            User managedUser = em.merge(user); // Assure que l'entité est gérée par le contexte de persistance
            em.remove(managedUser);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(String login) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class)
                     .setParameter("login", login)
                     .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(List<User> object) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public User convertToObject(ResultSet rs) {
        throw new UnsupportedOperationException("Method convertToObject not supported with JPA");
    }
}

