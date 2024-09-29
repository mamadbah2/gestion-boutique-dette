package com.sheet.core.factory;

import javax.persistence.EntityManager;

import com.sheet.data.repositories.interfaces.ArticleInterf;
import com.sheet.data.repositories.interfaces.ClientInterf;
import com.sheet.data.repositories.interfaces.DetteInterf;
import com.sheet.data.repositories.interfaces.UserInterf;
import com.sheet.data.repositories.jpa.ArticleRepoJPA;
import com.sheet.data.repositories.jpa.ClientRepoJPA;
import com.sheet.data.repositories.jpa.DetteRepoJPA;
import com.sheet.data.repositories.jpa.UserRepoJPA;

public class FactoryRepo {
    private ClientInterf clientRepo;
    private UserInterf userRepo;
    private ArticleInterf articleRepo;
    private DetteInterf detteRepo;
    private EntityManager config;

    public FactoryRepo(EntityManager config) {
        this.config = config;
    }

    public ClientInterf getInstanceOfClientRepo() {
        if (clientRepo == null) {
            clientRepo = new ClientRepoJPA(config);
        }
        return clientRepo;
    }

    public UserInterf getInstanceOfUserRepo() {
        if (userRepo == null) {
            userRepo = new UserRepoJPA(config);
        }
        return userRepo;
    }

    public ArticleInterf getInstanceOfArticleRepo() {
        if (articleRepo == null) {
            articleRepo = new ArticleRepoJPA(config);
        }
        return articleRepo;
    }

    public DetteInterf getInstanceOfDetteRepo() {
        if (detteRepo == null) {
            detteRepo = new DetteRepoJPA(config);
        }
        return detteRepo;
    }
}
