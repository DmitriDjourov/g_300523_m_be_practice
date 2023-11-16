package lesson5.application.database;

import lesson5.application.animals.Dog;
import lesson5.framework.annotations.Database;
import lesson5.framework.interfaces.AppDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Database
public class DogDatabase implements AppDatabase<Dog> {

    private Map<Integer, Dog> dogs = new HashMap<>();
    private int currentId;

    public DogDatabase() {
        add(2, "Шарик");
        add(4, "Бобик");
        add(6, "Дружок");
    }

    @Override
    public List<Dog> getAll() {
        return new ArrayList<>(dogs.values());
    }

    @Override
    public Dog getById(int id) {
        return dogs.get(id);
    }

    @Override
    public Dog add(int age, String name) {
        Dog dog = new Dog(++currentId, age, name);
        dogs.put(dog.getId(), dog);
        return dog;
    }

    @Override
    public void delete(int id) {
        dogs.remove(id);
    }
}