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
        BankAccount acct = new BankAccount("Elon Musk", 230f);
        assertTrue(acct.getBalance() == 230f);
        System.out.println("GetBalance succeeded.");
    }

    @Test
    public void testDeposit(){
        BankAccount acct = new BankAccount("Elon Musk", 230f);
        acct.deposit(15f);
        assertTrue(acct.getBalance() == 245f);
        System.out.println("GetBalance succeeded.");
    }
}
