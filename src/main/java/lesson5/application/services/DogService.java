package lesson5.application.services;

import lesson5.application.animals.Dog;
import lesson5.application.database.DogDatabase;
import lesson5.framework.annotations.AutoSet;
import lesson5.framework.annotations.Service;
import lesson5.framework.interfaces.AppService;

import java.util.List;

@Service
public class DogService implements AppService {

    @AutoSet
    private DogDatabase database;

    @Override
    public void printAll() {
        List<Dog> dogs = database.getAll();
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }

    @Override
    public void printOne(int id) {
        System.out.println(database.getById(id));
    }
}