package com.sheet.data.repositories;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sheet.core.repository.interfaces.Repository;

public class RepositoryListImpl<T> implements Repository<T> {
    private List<T> objects= new ArrayList<>(); ;

    @Override
    public void add(T object) {
        objects.add(object);
    }

    @Override
    public void remove(T object) {
        objects.remove(object);
    }

    @Override
    public void set(List<T> objects) {
        this.objects = objects;
    }

    @Override
    public List<T> getAll() {
        return objects;
    }

    @Override
    public T convertToObject(ResultSet rs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertToObject'");
    }

}
