package com.example.tp.interfaces;

public interface IDAO<T> {

    boolean create(T o);

    boolean add(T o);

    boolean modify(T o);

    boolean remove(T o);

}
