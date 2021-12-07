package swf.d2;

public class FixedDepositAccount extends BankAccount{
    private float interest = 3f;
    private boolean isInterestModified = false;
    private int durationinMonths = 6;
    private boolean isDurationModified = false;

    public FixedDepositAccount(){

    }

    @Override
    public boolean deposit(float amount){return false;}

    @Override
    public boolean withdraw(float amount){return false;}

    public static void main(String[] args) {
        
    }
}