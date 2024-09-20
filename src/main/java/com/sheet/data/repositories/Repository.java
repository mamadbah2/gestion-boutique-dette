package com.sheet.data.repositories;

import java.util.List;

public interface Repository<T> {
    public void add(T object);
    public void remove(T object);
    public void set(List<T> object);
    public List<T> getAll();
}
