package lesson5.application.services;

import lesson5.application.animals.Parrot;
import lesson5.application.database.ParrotDatabase;
import lesson5.framework.annotations.AutoSet;
import lesson5.framework.annotations.Service;
import lesson5.framework.interfaces.AppService;

import java.util.List;

@Service
public class ParrotService implements AppService {

    @AutoSet
    private ParrotDatabase database;

    @Override
    public void printAll() {
        List<Parrot> parrots = database.getAll();
        for (Parrot parrot : parrots) {
            System.out.println(parrot);
        }
    }

    @Override
    public void printOne(int id) {
        System.out.println(database.getById(id));
    }
}