package swf.d2;

public class FixedDepositAccount extends BankAccount{
    private float interest = 3f;
    private boolean isInterestModified = false;
    private int duration = 6;
    private boolean isDurationModified = false;

    public FixedDepositAccount(String name){
        super(name);
    }

    public FixedDepositAccount(String name, float accountBalance){
        super(name, accountBalance);
    }

    @Override
    public boolean deposit(float amount){return false;}

    @Override
    public boolean withdraw(float amount){return false;}

    public boolean setDuration(int months) {
        boolean success = true;
        if (isDurationModified) {
            success = false;
            throw new IllegalArgumentException();
        } else {
            isDurationModified = true;
            this.duration = months;
        }
        return success;
    }

    public int getDuration(){
        return duration;
    }
    
    public boolean setInterest(float amount) {
        boolean success = true;
        if (isInterestModified) {
            success = false;
            throw new IllegalArgumentException();
        } else {
            isInterestModified = true;
            this.interest = amount;
        }
        return success;
    }

    public float getInterest(){
        return interest;
    }

    public static void main(String[] args) {
        
    }
}