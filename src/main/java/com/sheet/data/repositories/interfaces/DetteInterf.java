package com.sheet.data.repositories.interfaces;

import com.sheet.data.entities.Dette;
import com.sheet.data.repositories.Repository;

public interface DetteInterf extends Repository<Dette> {
    public Dette getDette(String date);
}
