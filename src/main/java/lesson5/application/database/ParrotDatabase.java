package lesson5.application.database;

import lesson5.application.animals.Parrot;
import lesson5.framework.annotations.Database;
import lesson5.framework.interfaces.AppDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Database
public class ParrotDatabase implements AppDatabase {

    private Map<Integer, Parrot> parrots = new HashMap<>();
    private int currentId;

    public ParrotDatabase() {
        add(3, "Кеша");
        add(6, "Пират");
        add(9, "Сильвер");
    }

    @Override
    public List<Parrot> getAll() {
        return new ArrayList<>(parrots.values());
    }

    @Override
    public Parrot getById(int id) {
        return parrots.get(id);
    }

    @Override
    public Parrot add(int age, String name) {
        Parrot parrot = new Parrot(++currentId, age, name);
        parrots.put(parrot.getId(), parrot);
        return parrot;
    }

    @Override
    public void delete(int id) {
        parrots.remove(id);
    }
}