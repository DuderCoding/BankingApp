package bankAccountBasic;

public class PrivateAccount {

    private String customerID;
    private String lastName;
    private int amount;
    private int balance;
    private int previousTransaction;

    public PrivateAccount(){
    }

    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void deposit(int amount){
        this.balance += amount;
        System.out.println("You have deposited £"+amount+"\n");
        previousTransaction = amount;
    }
    public void withdraw(int amount){

        if((this.balance-amount)<0) {
            System.out.println("Sorry, you have do not have enough money in your account to withdraw £"+amount+". Please select a lower amount.\n");
        }
        else{
            this.balance -= amount;
            System.out.println("Withdrawing £"+amount+". Please wait whilst we dispense your cash...\n");
            previousTransaction = -amount;
        }
    }
    public String getCustomerID(){
        System.out.print("Your customer ID is: ");
        return customerID;
    }
    public String getLastName(){
        System.out.print("Your username that is registered with us is: ");
        return lastName;
    }
    public void getBalance(){
        System.out.print("Your balance is: £"+balance+"\n\n");
    }
    public void getPreviousTransaction(){
        if(previousTransaction>0){
            System.out.println("You have deposited £"+previousTransaction);
        }
        else if(previousTransaction<0){
            System.out.println("You have withdrawn £"+Math.abs(previousTransaction));
        }
        else{
            System.out.println("No transaction occurred");
        }
    }

}
