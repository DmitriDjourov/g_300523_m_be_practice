package lesson7.task3;

public class BankAccount {
    private int amount;

    public BankAccount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public synchronized boolean withDrawMany(int many) {
        if (amount >= many) {
            amount = amount - many;
            return true;
        }
        return false;
    }
}
