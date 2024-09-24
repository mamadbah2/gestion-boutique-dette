package com.sheet.core.repository.interfaces;

import java.util.List;

import java.sql.ResultSet;

public interface Repository<T> {
    public void add(T object);
    public void remove(T object);
    public void set(List<T> object);
    public List<T> getAll();
    public T convertToObject(ResultSet rs);
}
