package com.BankSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Accounts {
    private double balance;
    private final String userName;
    private final String customerId;

    public Accounts(String userName, String customerId) {
        this.userName = userName;
        this.customerId = customerId;
        this.balance = 0.00;

    }
    private void add() throws InputMismatchException{

        /** This Method is helper method for main manu method. It is used when user selects 'b'
         *  and it asks the user to enter the amount of the money which is going ot be deposited
         *  to balance. **/

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("How much would you like to add: ");
            double amount = sc.nextDouble();
            if (amount < 0) return;
            System.out.println("You entered "+ amount + "€. You new balance is " + (balance + amount) + "€\n");
            balance += amount;
        } catch (InputMismatchException e ){
            System.out.println("Enter valid number in this format --> 0.00");
        }

    }
    private void withdraw() throws InputMismatchException{

        /** This Method is helper method for main manu method. It is used when user selects 'c'
         *  and it asks the user to enter the amount of the money which is going ot be withdrawn
         *  from the balance. **/

        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("How much would you like to withdraw: ");
            double amount = sc.nextDouble();
            if (amount > balance || amount < 0) {
                System.out.println("Invalid value or insufficient balance. ");
                return;
            }
            System.out.println("Withdrawal of " + amount + " successful, you remaining balance is " + (balance-amount)+ "\n");
            balance -= amount;
        } catch (InputMismatchException e ){
            System.out.println("Enter valid number in this format --> 0.00");
        }
    }

    private void getBalance() {

        /** This Method is helper method for main manu method. It is used when user selects 'a'.
         *  Method is going to display the balance. **/

        System.out.println("You current balance is " + balance + "€\n");
    }

    public void menu() {

        /** METHOD DISPLAYS MAIN MENU FOR THE CUSTOMER **/

        Scanner sc = new Scanner(System.in);
        char option;

        System.out.println("\n\nWelcome " + userName);
        System.out.println("Your ID:" + customerId);
        System.out.println();

        do {
            System.out.println("a) Check Balance");
            System.out.println("b) Deposit Amount");
            System.out.println("c) Withdraw Amount");
            System.out.println("e) Exit");
            System.out.println("********************************************");
            System.out.print("Choose an option: ");
            option = sc.nextLine().toLowerCase().charAt(0);
            System.out.println("\n");

            if (option == 'a') {
                getBalance();
            } else if (option == 'b') {
                add();
            } else if (option == 'c') {
                withdraw();
            } else if (option == 'e'){
                System.out.println("Thank you, have a great day!");
                break;
            } else {
                System.out.println("Invalid option try again");
            }
        } while(option!='e');
    }
}
