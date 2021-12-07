package swf.d2;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String name;
    private String accountNumber;
    private float balance;
    private String dateCreated;
    private String dateClosed;
    private ArrayList<String> transactions;
    private boolean closed;

    public BankAccount(String name) {
        this.name = name;
        accountNumber = ""+Math.random()*1000000000;
        balance = 0;
        dateCreated = timeStamp();
        transactions = new ArrayList<String>();
        closed = false;
        
    }

    public BankAccount(String name, float balance) {
        this.name = name;
        accountNumber = ""+Math.random()*1000000000;
        this.balance = balance;
        dateCreated = timeStamp();
        transactions = new ArrayList<String>();
        closed = false;
    }

    /**
     * @return boolean adds amount to balance and logs it in transactions.
     */
    public boolean deposit(float amount) {
        boolean success = true;
        if (amount <= 0 || closed) {
            success = false;
            throw new IllegalArgumentException();
        } else {
            balance += amount;
            transactions.add("deposit $" + amount + " at " + timeStamp());
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
     * @return String return the balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * @return String return the dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return String return the dateClosed
     */
    public String getDateClosed() {
        return dateClosed;
    }

    /**
     * @param dateClosed the dateClosed to set
     */
    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
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

    private String timeStamp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }


    /**
     * @return boolean subtracts amount to balance and logs it in transactions.
     */
    public boolean withdraw(float amount) {
        boolean success = true;
        if (amount <= 0 || closed) {
            success = false;
            throw new IllegalArgumentException();
        } else {
            balance -= amount;
            transactions.add("withdraw $" + amount + " at " + timeStamp());
        }
        return success;
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
