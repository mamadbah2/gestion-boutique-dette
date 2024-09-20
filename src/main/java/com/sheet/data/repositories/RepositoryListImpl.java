package com.sheet.data.repositories;

import java.util.ArrayList;
import java.util.List;

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
    
}
