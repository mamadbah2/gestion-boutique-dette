package com.sheet.core.factory;

import com.sheet.data.repositories.db.ArticleRepoDB;
import com.sheet.data.repositories.db.ClientRepoDB;
import com.sheet.data.repositories.db.DetteRepoDB;
import com.sheet.data.repositories.db.UserRepoDB;
import com.sheet.data.repositories.interfaces.ArticleInterf;
import com.sheet.data.repositories.interfaces.ClientInterf;
import com.sheet.data.repositories.interfaces.DetteInterf;
import com.sheet.data.repositories.interfaces.UserInterf;

public class FactoryRepo {
    private ClientInterf clientRepo;
    private UserInterf userRepo;
    private ArticleInterf articleRepo;
    private DetteInterf detteRepo;

    public FactoryRepo() {
    }

    public ClientInterf getInstanceOfClientRepo() {
        if (clientRepo == null) {
            clientRepo = new ClientRepoDB();
        }
        return clientRepo;
    }

    public UserInterf getInstanceOfUserRepo() {
        if (clientRepo == null) {
            userRepo = new UserRepoDB();
        }
        return userRepo;
    }

    public ArticleInterf getInstanceOfArticleRepo() {
        if (articleRepo == null) {
            articleRepo = new ArticleRepoDB();
        }
        return articleRepo;
    }

    public DetteInterf getInstanceOfDetteRepo() {
        if (detteRepo == null) {
            detteRepo = new DetteRepoDB();
        }
        return detteRepo;
    }
}
