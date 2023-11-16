package lesson5.framework.source;

import lesson5.framework.annotations.AutoRun;
import lesson5.framework.annotations.AutoSet;
import lesson5.framework.annotations.Database;
import lesson5.framework.annotations.Service;
import lesson5.framework.interfaces.AppService;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Framework {

    private static Reflections reflections;
    private static Set<Object> databases;
    private static Set<Object> services;

    public static void run(Class<?> appClass) {
        Package parentPackage = appClass.getPackage();
        reflections = new Reflections(parentPackage.getName());

        databases = getAnnotatedInstances(Database.class);
        invokeAutoRunMethods();
        services = getAnnotatedInstances(Service.class);

        setDatabasesToServices();

        work();
    }

    private static void invokeAutoRunMethods() {
        for (Object database : databases) {
            Method[] methods = database.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(AutoRun.class)) {
                    try {
                        method.invoke(database);
                    } catch (Exception e) {
                        System.out.println("Не удалось вызвать стартовый метод базы данных.");
                    }
                }
            }
        }
    }

    private static Set<Object> getAnnotatedInstances(Class<? extends Annotation> annotation) {
        Set<Class<?>> dbClasses = reflections.getTypesAnnotatedWith(annotation);
        Set<Object> result = new HashSet<>();

        try {
            for (Class<?> dbClass : dbClasses) {
                Object db = dbClass.getDeclaredConstructor().newInstance();
                result.add(db);
            }
        } catch (Exception e) {
            System.out.println("Не удалось создать базу данных либо сервис!");
        }

        return result;
    }

    private static void setDatabasesToServices() {
        for (Object service : services) {
            Field[] fields = service.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutoSet.class)) {
                    Class<?> type = field.getType();
                    for (Object database : databases) {
                        if (database.getClass().equals(type)) {
                            try {
                                field.setAccessible(true);
                                field.set(service, database);
                                break;
                            } catch (IllegalAccessException e) {
                                System.out.println("Не удалось засеттить базу данных в сервис!");;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void work() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите запрос или exit для выхода.");
            String input = scanner.nextLine();

            if ("exit".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            String type = parts[0];
            AppService service = getService(type);

            try {
                if ("all".equals(parts[1])) {
                    service.printAll();
                } else {
                    service.printOne(Integer.parseInt(parts[1]));
                }
            } catch (Exception e) {
                System.out.println("Неверный запрос!");
            }
        }
    }

    private static AppService getService(String type) {
        for (Object service : services) {
            if (service.getClass().getSimpleName().toLowerCase().startsWith(type)) {
                return (AppService) service;
            }
        }
        return null;
    }
}