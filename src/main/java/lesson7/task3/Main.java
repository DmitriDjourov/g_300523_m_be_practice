package lesson7.task3;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1500);
        Consumer consumer1 = new Consumer(bankAccount, "John");
        Consumer consumer2 = new Consumer(bankAccount, "Pit");
//        consumer1.run();
//        consumer2.run();
        consumer1.start();
        consumer2.start();
        try {
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Остаток средств на счету " + bankAccount.getAmount());

    }
}
