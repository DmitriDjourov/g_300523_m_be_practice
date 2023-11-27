package lesson8.task1;


public class DeamonThread extends Thread {

    public DeamonThread() {
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Отработал ДемонПоток");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
