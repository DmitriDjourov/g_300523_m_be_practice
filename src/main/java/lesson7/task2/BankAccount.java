package lesson7.task2;

public class BankAccount {
    private int amount;

    public BankAccount(int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }
    public void withDrawMany(int many){
        amount = amount - many;
    }
}
