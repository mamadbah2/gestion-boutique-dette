package com.sheet.core.factory;


import com.sheet.data.repositories.interfaces.ArticleInterf;
import com.sheet.data.repositories.interfaces.ClientInterf;
import com.sheet.data.repositories.interfaces.DetteInterf;
import com.sheet.data.repositories.interfaces.UserInterf;
import com.sheet.services.ArticleServ;
import com.sheet.services.ClientServ;
import com.sheet.services.DetteServ;
import com.sheet.services.UserServ;

public class FactoryServ {
    // ---------------------------------------
    private ClientServ clientServ;
    private UserServ userServ;
    private ArticleServ articleServ;
    private DetteServ detteServ;
    // ---------------------------------------
    private ClientInterf clientRepo;
    private UserInterf userRepo;
    private ArticleInterf articleRepo;
    private DetteInterf detteRepo;
    // ---------------------------------------
   

    public FactoryServ(ClientInterf clientRepo, UserInterf userRepo, ArticleInterf articleRepo, DetteInterf detteRepo) {
        this.clientRepo = clientRepo;
        this.userRepo = userRepo;
        this.articleRepo = articleRepo;
        this.detteRepo = detteRepo;
    }

    public ClientServ getInstanceOfClientServ() {
        if (clientServ == null) {
            clientServ = new ClientServ(clientRepo);
        }
        return clientServ;
    }

    public UserServ getInstanceOfUserServ() {
        if (userServ == null) {
            userServ = new UserServ(userRepo);
        }
        return userServ;
    }
    
    public ArticleServ getInstanceOfArticleServ() {
        if (articleServ == null) {
            articleServ = new ArticleServ(articleRepo);
        }
        return articleServ;
    }

    public DetteServ getInstanceOfDetteServ() {
        if (detteServ == null) {
            detteServ = new DetteServ(detteRepo);
        }
        return detteServ;
    }

}
