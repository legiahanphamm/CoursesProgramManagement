package dao;

import java.util.ArrayList;

public interface DaoInt<E> {
    public ArrayList<E> getAll();
    public E input();
    public void add(E e);
    public Object searchByCode(String code);
    public Object inputUpdateInfo();
    public Object update(String code);
    public void remove(String code);
}