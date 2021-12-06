package swf.d2;

public Class FixedDepositAccount extends BankAccount{
    private float interest = 3.0;
    private boolean isInterestModified = false;
    private int durationinMonths = 6;
    private boolean isDurationModified = false;

    public FixedDepositAccount(){

    }

    @Override
    public void withdraw(){}

    public static void main(String[] args) {
        
    }
}