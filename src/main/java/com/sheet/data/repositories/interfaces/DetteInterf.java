package com.sheet.data.repositories.interfaces;

import com.sheet.core.repository.interfaces.Repository;
import com.sheet.data.entities.Dette;

public interface DetteInterf extends Repository<Dette> {
    public Dette getDette(String date);
}
