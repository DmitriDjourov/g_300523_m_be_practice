package lesson5.application.database;

import lesson5.application.animals.Cat;
import lesson5.framework.annotations.AutoRun;
import lesson5.framework.annotations.Database;
import lesson5.framework.interfaces.AppDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Database
public class CatDatabase implements AppDatabase<Cat> {

    private Map<Integer, Cat> cats = new HashMap<>();
    private int currentId;

    @AutoRun
    public void init() {
        add(1, "Барсик");
        add(3, "Мурзик");
        add(5, "Пушок");
    }

    @Override
    public List<Cat> getAll() {
        return new ArrayList<>(cats.values());
    }

    @Override
    public Cat getById(int id) {
        return cats.get(id);
    }

    @Override
    public Cat add(int age, String name) {
        Cat cat = new Cat(++currentId, age, name);
        cats.put(cat.getId(), cat);
        return cat;
    }

    @Override
    public void delete(int id) {
        cats.remove(id);
    }
}