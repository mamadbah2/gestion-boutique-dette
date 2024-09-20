package com.sheet.services;

import java.util.List;

import com.sheet.data.entities.Dette;
import com.sheet.data.repositories.interfaces.DetteInterf;

public class DetteServ {
    private DetteInterf detteRepo;

    public DetteServ(DetteInterf detteRepo) {
        this.detteRepo = detteRepo;
    }

    public void ArchivedDette(Dette dette) {
        detteRepo.remove(dette);
    }

    public List<Dette> findDettes() {
        return detteRepo.getAll();
    }
}
