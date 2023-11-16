package lesson5.application.services;

import lesson5.application.animals.Cat;
import lesson5.application.database.CatDatabase;
import lesson5.framework.annotations.AutoSet;
import lesson5.framework.annotations.Service;
import lesson5.framework.interfaces.AppService;

import java.util.List;

@Service
public class CatService implements AppService {

    @AutoSet
    private CatDatabase database;

    @Override
    public void printAll() {
        List<Cat> cats = database.getAll();
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }

    @Override
    public void printOne(int id) {
        System.out.println(database.getById(id));
    }
}