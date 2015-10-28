/*
 * ATM Example system - file Withdrawal.java    
 *
 * copyright (c) 2001 - Russell C. Bjork
 *
 */
 
package atm.transaction;
import atm.ATM;
import atm.Session;
import atm.physical.*;
import banking.AccountInformation;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Status;
import banking.Receipt;

/** Representation for a cash withdrawal transaction
 */
public class Withdrawal extends Transaction
{
    /** Constructor
     *
     *  @param atm the ATM used to communicate with customer
     *  @param session the session in which the transaction is being performed
     *  @param card the customer's card
     *  @param pin the PIN entered by the customer
     */
    public Withdrawal(ATM atm, Session session, Card card, int pin)
    {
        super(atm, session, card, pin);
    }
    
    /** Get specifics for the transaction from the customer
     *
     *  @return message to bank for initiating this transaction
     *  @exception CustomerConsole.Cancelled if customer cancelled this transaction
     */
    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled
    {
        from = atm.getCustomerConsole().readMenuChoice(
            "Account to withdraw from",
            AccountInformation.ACCOUNT_NAMES);

        String [] amountOptions = { "$20", "$40", "$60", "$100", "$200" };
        Money [] amountValues = { 
                                  new Money(200), new Money(1000), new Money(20),
                                  new Money(10), new Money(0)
                                };
                                  
        String amountMessage = "";
        boolean validAmount = false;
        
        while (! validAmount)
        {
            amount = amountValues [ 
                atm.getCustomerConsole().readMenuChoice(
                    amountMessage + "Amount of cash to withdraw", amountOptions) ];
                            
            validAmount = atm.getCashDispenser().checkCashOnHand(amount);

            if (! validAmount)
                amountMessage = "Insufficient cash available\n";
        }
        
        return new Message(Message.WITHDRAWAL, 
                           card, pin, serialNumber, from, -1, amount);

    }
    
    /** Complete an approved transaction
     *
     *  @return receipt to be printed for this transaction
     */
    protected Receipt completeTransaction()
    {
        atm.getCashDispenser().dispenseCash(amount);
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[2];
                detailsPortion[0] = "WITHDRAWAL FROM: " + 
                                    AccountInformation.ACCOUNT_ABBREVIATIONS[from];
                detailsPortion[1] = "AMOUNT: " + amount.toString();
            }
        };
    }
    
    /** Account to withdraw from
     */ 
    private int from;
    
    /** Amount of money to withdraw
     */
    private Money amount;           
}
