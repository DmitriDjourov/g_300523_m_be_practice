package lesson10.task2;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Courier implements Runnable {
    private String start;
    private String destination;
    private List<Package> packageList;
    private Courier anotherCourier;
    private boolean inExchangePoint;
    private Exchanger<Package> exchanger;

    public Courier(String start, String destination, List<Package> packageList, Exchanger<Package> exchanger) {
        this.start = start;
        this.destination = destination;
        this.packageList = packageList;
        this.exchanger = exchanger;
    }

    private void unload() {//метод для разгрузки, пробежаться по всем посылкам и посмотреть если адрес совпадает, выгружаем эту посылку
        Iterator<Package> iterator = packageList.iterator();
        while (iterator.hasNext()) {
            Package p = iterator.next();
            if (p.getAddressOfArrival().equals(destination)) {
                System.out.printf("%s успешно доставил %s\n", this, p);
                iterator.remove();//те посылки которые выгрузили на точке, удалили из списка
            }
        }
        if (!packageList.isEmpty()) {
            System.out.printf("%s доставил не все посылки\n", this);
        } else {
            System.out.printf("%s доставил все посылки\n", this);
        }
    }

   /**
    * метод обустраивает пункт обмена между курьерами,
    * отдать неудобную посылку, если пункт назначения посылки не совпадает
    * с пунктом где находится курьер.
    * Курьер убирает посылку из списка и метод возвращает посылку, которую заберет другой курьер
   * */
    private Package getUnconvinientPackage() {
        Iterator<Package> iterator = packageList.iterator();
        while (iterator.hasNext()) {
            Package p = iterator.next();
            if (!p.getAddressOfArrival().equals(destination)) {
                iterator.remove();//те посылки которые отдали второму курьеру, удалили из списка
                System.out.printf("%s передал %s другому курьеру\n", this, p);
                return p;
            }
        }
        return null;
    }

    public void setAnotherCourier(Courier anotherCourier) {
        this.anotherCourier = anotherCourier;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int delaytime = random.nextInt(1_000, 10_000);
            Thread.sleep(delaytime);
            System.out.printf("%s выехал из точки %s\n", this, start);

            Thread.sleep(delaytime);
            System.out.printf("%s доехал до пункта обмена\n", this);
//            inExchangePoint = true;
//            if (anotherCourier.inExchangePoint){
//                packageList.add(anotherCourier.exchange());//добавляем посылку от другого курьера
//            }
            /**
            * обмен неудобными посылками. Меняемся в exchange посылками и добавляем себе эту посылку в лист
            * */
            packageList.add(exchanger.exchange(getUnconvinientPackage()));//внутрь передаем то, чем должны обменяться
            Thread.sleep(delaytime);
//            if (anotherCourier.inExchangePoint){// еще одна попытка обмена, после паузы, перед выездом
//                packageList.add(anotherCourier.exchange());//добавляем посылку от другого курьера
//            }
//            inExchangePoint = false;
            System.out.printf("%s уехал из пункта обмена\n", this);

            Thread.sleep(delaytime);
            System.out.printf("%s доехал до точки выгрузки %s\n", this, destination);

            Thread.sleep(delaytime);
            unload();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    @Override
    public String toString() {
        return "Курьер: " + start + " -> " + destination;
    }
}
