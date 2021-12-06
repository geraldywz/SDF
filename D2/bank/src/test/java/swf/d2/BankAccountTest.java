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
        assertTrue(acct.getAccountBalance() == 23000000000f);
    }
}
