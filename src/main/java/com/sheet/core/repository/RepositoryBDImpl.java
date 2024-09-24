package com.sheet.core.repository;

import java.util.List;

import com.sheet.core.database.DatabaseImpl;
import com.sheet.core.repository.interfaces.Repository;

public abstract class RepositoryBDImpl<T> extends DatabaseImpl implements Repository<T> {
    public RepositoryBDImpl() {
        super();
    }

    @Override
    public void add(Object object) {
        // TODO Auto-generated method stub
    }

    @Override
    public void remove(Object object) {
        // TODO Auto-generated method stub
    }

    @Override
    public void set(List<T> object) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<T> getAll() {
        // TODO Auto-generated method stub
        return null;
    }


    
}
