package com.example.swanabank;


public class Account {
    private static double annualInterestRate;
    private int nextAccountNb = 300;
    private int accountNb;
    private String f_name;
    private String l_name;
    private double balance;
    private java.util.Date dateCreated;

    //	construct the Account object
    public Account(String f_name, String l_name, double balance) {
        this.f_name = f_name;
        this.l_name = l_name;
        this. balance =  balance;
        dateCreated = new java.util.Date();
        this.accountNb = nextAccountNb;
        Account.annualInterestRate = 4.5;
        nextAccountNb++;

    }

    public int getAccountNb() {
        return accountNb;
    }

    public void setAccountNb(int accountNb) {
        this.accountNb = accountNb;
    }

    public String getFirstName() {
        return f_name;
    }

    public void setFirstName(String f_name) {
        this.f_name = f_name;
    }

    public String getLastName() {
        return l_name;
    }

    public void setLastName(String l_name) {
        this.l_name = l_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        annualInterestRate = Account.annualInterestRate;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }


    public double getMonthlyInterestRate() {
        double monthlyIntesrestRate = annualInterestRate / 1200;
        return monthlyIntesrestRate;
    }

    public double withdraw(double amount) {
        return amount;
    }

    public double deposit(double amount) {
        return amount;
    }

}