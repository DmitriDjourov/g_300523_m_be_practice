package lesson7.task3;

public class Consumer extends Thread {
    private BankAccount bankAccount;

    public Consumer(BankAccount bankAccount, String name) {
        this.bankAccount = bankAccount;
        setName(name);
    }

    @Override
    public void run() {
        //Шаг1: решим сколько денег снимать
        //Шаг2: подойти к банкомату
        //Шаг3: проверить баланс
        //Шаг4: постоять и подумать хватает ли денег
        //Шаг5: если денег хватает, то снять
        try {
            int howMany = 1000;
            Thread.sleep(3000);
            System.out.println("Клиент "+getName() + " подошел к банкомату!");
            int manyAmount = bankAccount.getAmount();
            Thread.sleep(2000);
            if (bankAccount.withDrawMany(howMany)){
                System.out.println("Клиент "+getName() + " успешно снял деньги!");
            }else {
                System.out.println("Клиенту "+getName() + " не хватило денег!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
