package bankAccountAdvanced;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int choice=0;
        int amount=0;
        boolean correctVal=false;
        int accountsCounter = 0;
        System.out.println("\nWelcome to Dilberto Bank. Please choose from the following options:");

        Scanner scanner = new Scanner(System.in);
        PrivateAccount privateAccount = new PrivateAccount();

        do{
            System.out.println("\t1 - Create a new account.\n\t2 - Get my customer ID\n\t3 - Get my username\n\t4 - Get my balance\n\t5 - Make a deposit\n\t6 - Make a withdrawel\n\t7 - Show Previous Transaction\n\t8 - Exit");
            choice = getUserInputChoice(8);
            switch (choice) {
                case 1:
                    System.out.println("\nYou have chossen to create an account, we will generate a unique customer ID - please remember it");

                    Random random = new Random();
                    int upperBound = 100000;
                    int newCustomerID = random.nextInt(upperBound);
                    String customerID = String.format("%06d", newCustomerID);
                    accountsCounter+=1;

                    System.out.println("\nYour new unique customer ID is: " + customerID);
                    privateAccount.setCustomerID(customerID);

                    System.out.println("Please enter a username");
                    String lastName = scanner.nextLine();
                    privateAccount.setLastName(lastName);


                    System.out.println("\nWould you like to make a deposit into your new account?\n\t1 - Yes\n\t2 - No");
                    int choice2 = 0;
                    choice2 = getUserInputChoice(2);
                    do {
                        switch (choice2) {
                            case 1:
                                System.out.println("Please enter the amount you would like to deposit:");
                                amount = intInputChecker();
                                privateAccount.deposit(amount);
                                correctVal=true;
                                break;
                            case 2:
                                System.out.println("You have chossen not to make a deposit.");
                                correctVal=true;
                                break;
                        }
                    } while (correctVal != true);
                    break;
                case 2:
                    System.out.println("\nWe will fetch your customer ID, please wait...");
                    System.out.println(privateAccount.getCustomerID());
                    break;
                case 3:
                    System.out.println("\nWe will fetch your username, please wait...");
                    System.out.println(privateAccount.getLastName());
                    break;
                case 4:
                    System.out.println("\nWe will print your balance, please wait...");
                    privateAccount.getBalance();
                    break;
                case 5:
                    System.out.println("Please enter the amount you would like to deposit: ");
                    amount = intInputChecker();
                    privateAccount.deposit(amount);
                    break;
                case 6:
                    System.out.println("Please enter the amount you would like to withdraw");
                    amount = intInputChecker();
                    privateAccount.withdraw(amount);
                    break;
                case 7:
                    System.out.println("Fetching your last transaction...");
                    privateAccount.getPreviousTransaction();
                case 8:
                    System.out.println("\nThank you for choosing Dilberto Bank, have a pleasant day.");
                    break;
            }
        }while(choice!=8);
    }



    public static int intInputChecker(){
        Scanner scanner2 = new Scanner(System.in);
        boolean flag=false;

        do {
            if (!scanner2.hasNextInt()) {
                System.out.println("Please enter a number");
                scanner2.next();
                continue;
            }
            flag = true;
        }while(!flag);

        return scanner2.nextInt();
    }
    public static int getUserInputChoice(int numOfChoices){
        int choiceOf5=0;
        boolean validChoice = false;
        Scanner scanner1 = new Scanner(System.in);
        int[] choices = {1,2,3,4,5,6,7,8};

        do {
            if (!scanner1.hasNextInt()) {
                System.out.println("Please enter 1-"+numOfChoices);
                scanner1.next();
                continue;
            } else {
                choiceOf5 = scanner1.nextInt();
                for (int i=0;i<numOfChoices;i++) {
                    if (choiceOf5 == choices[i]) {
                        validChoice = true;
                        break;
                    } else {
                        validChoice = false;
                    }
                }
                if (validChoice==false){
                    System.out.println("Please enter 1-"+numOfChoices);
                }
            }
        } while(!validChoice);

        return choiceOf5;
    }
}
