package com.example.swanabank;

//This program will open a bank account for the user.
//It sets up an annual interest rate
//Then, it will first ask for First and last name. With these, the program automatically
//creates an account with an initial balance of $100.
//It displays the account details including monthly interest on the current balance
//The program allows the user to deposit and withdraw as many times as they wish.
//And finally ends with a Goodbye message

import java.util.Scanner;

public class TestAccount {
    public static void main(String[] args) {

        System.out.println("	****** Welcome to SWANA Bank *****	\n");

//		access annual interest rate
        System.out.printf("Today's Interest Rate is = %.1f%%%n%n", Account.getAnnualInterestRate());

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String f_name = input.nextLine();

        System.out.print("Enter last name: ");
        String l_name = input.nextLine();
        System.out.print("\n");

        double balance = 100;

        Account account = new Account(f_name, l_name, balance);

//		Create an Account for the user
        System.out.printf("Your account details are:\n\nName is: %s\nAccount number is %d%nCurrent balance is $%.1f%nInterest Rate is %.1f%%%nMonthly interest for this balance is $%.3f%n" + "This account was created on %s%n%n",
                account.getFirstName() + " " + account.getLastName(), account.getAccountNb(), account.getBalance(), Account.getAnnualInterestRate(), account.getMonthlyInterestRate()*account.getBalance(), account.getDateCreated().toString());

        int userChoice = 3;

// 		Keep on prompting for valid input i.e number between 0 and 2
        while(userChoice > 2) {

            System.out.print("Enter your choice (0: Deposit, 1:Withdraw, 2:Quit): ");

            userChoice = input.nextInt();
        }
//		as long as user doesn't choose to quit, keep prompting if he wants to deposit or withdraw
        while(userChoice != 2) {

//			case where user wants to deposit
            if(userChoice == 0) {

                System.out.print("Enter the amount: $");

                double amount = input.nextDouble();

                account.setBalance(amount);

//				case where user wants to withdraw
            } else if(userChoice == 1) {

                System.out.print("Enter the amount: $");

                double amount = input.nextDouble();

//				 deduct amount if withdrawing amount is less than balance
                if((int)amount <= (int)account.getBalance()) {

                    account.setBalance(-amount);
//					if withdrawing amount is more than balance, break out of loop
                } else {

                    break;
                }

            }

            System.out.print("\n");
            System.out.print("Enter your choice (0: Deposit, 1:Withdraw, 2:Quit): ");
            userChoice = input.nextInt();
        }
//		Give final balance
        System.out.print("\n");
        System.out.printf("New balance is $%.1f%nGood Bye!", account.getBalance());


        input.close();
    }
}
