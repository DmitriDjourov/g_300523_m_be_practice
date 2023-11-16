package lesson5.framework.interfaces;

import java.util.List;

public interface AppDatabase<T> {

    List<T> getAll();

    T getById(int id);

    public T add(int age, String name);

    public void delete(int id);
}