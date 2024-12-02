package com.sheet.data.repositories.list;

import java.util.ArrayList;
import java.util.List;

import com.sheet.data.entities.Dette;
import com.sheet.data.repositories.ListImpl;
import com.sheet.data.repositories.interfaces.DetteInterf;

public class DetteRepoList extends ListImpl<Dette> implements DetteInterf {
    private List<Dette> dettes = new ArrayList<Dette>();

    public Dette getDette(String date) {
        for (Dette dette : dettes) {
            if (dette.getDate().equals(date)) {
                return dette;
            }
        }
        return null;
    }

}
