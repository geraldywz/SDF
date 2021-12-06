package swf.d2;

import java.util.List;

public class BankAccount {
    private String name;
    private String accountNumber;
    private float accountBalance;
    private String accountCreateDate;
    private String accountCloseDate;
    private List<String> transactions;
    private boolean isClosed;

    public void BankAccount() {
    }

    public void BankAccount(String name) {
        this.name = name;
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
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    /**
     * @return boolean return the isClosed
     */
    public boolean isIsClosed() {
        return isClosed;
    }

    /**
     * @param isClosed the isClosed to set
     */
    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public static void main(String[] args) {

    }

}
