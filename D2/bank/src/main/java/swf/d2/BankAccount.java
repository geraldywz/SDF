package swf.d2;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String name;
    private String accountNumber;
    private float accountBalance;
    private String accountCreateDate;
    private String accountCloseDate;
    private ArrayList<String> transactions;
    private boolean closed;

    public BankAccount(String name) {
        this.name = name;
        accountNumber = ""+Math.random()*1000000000;
        accountBalance = 0;
        accountCreateDate = nowToString();
        transactions = new ArrayList<String>();
        closed = false;
        
    }

    public BankAccount(String name, float accountBalance) {
        this.name = name;
        accountNumber = ""+Math.random()*1000000000;
        this.accountBalance = accountBalance;
        accountCreateDate = nowToString();
        transactions = new ArrayList<String>();
        closed = false;
    }

    /**
     * @return String return the name
     */
    public boolean deposit(float amount) {
        boolean success = true;
        if (amount <= 0 || closed) {
            success = false;
            throw new IllegalArgumentException();
        } else {
            accountBalance += amount;
            transactions.add("deposit $" + amount + " at " + nowToString());
        }
        return success;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return String return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return String return the accountBalance
     */
    public float getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param accountBalance the accountBalance to set
     */
    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * @return String return the accountCreateDate
     */
    public String getAccountCreateDate() {
        return accountCreateDate;
    }

    /**
     * @param accountCreateDate the accountCreateDate to set
     */
    public void setAccountCreateDate(String accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    /**
     * @return String return the accountCloseDate
     */
    public String getAccountCloseDate() {
        return accountCloseDate;
    }

    /**
     * @param accountCloseDate the accountCloseDate to set
     */
    public void setAccountCloseDate(String accountCloseDate) {
        this.accountCloseDate = accountCloseDate;
    }

    /**
     * @return List<String> return the transactions
     */
    public List<String> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    /**
     * @return boolean return the closed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * @param closed the closed to set
     */
    public void isClosed(boolean newStatus) {
        this.closed = newStatus;
    }

    private String nowToString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Bill Gates");
        System.out.println(ba.getAccountNumber());
        ba = new BankAccount("Jeff Bezos");
        System.out.println(ba.getAccountNumber());
        ba = new BankAccount("Warren Buffet");
        System.out.println(ba.getAccountNumber());
    }

}
