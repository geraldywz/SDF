package swf.d2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for BankAccount.
 */
public class BankAccountTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testGetBalance(){
        BankAccount acct = new BankAccount("Elon Musk", 23000000000f);
        assertTrue(acct.getBalance() == 23000000000f);
        System.out.println("GetBalance succeeded.");
    }

    @Test
    public void testDeposit(){
        BankAccount acct = new BankAccount("Elon Musk", 23000000000f);
        acct.deposit(15f);
        assertTrue(acct.getBalance() == 230000000015f);
        System.out.println("GetBalance succeeded.");
    }
}
