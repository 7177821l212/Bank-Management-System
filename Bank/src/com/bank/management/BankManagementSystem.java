package com.bank.management;

import java.util.*;

public class BankManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Account> accounts = new HashMap<>();
    private static int accountNumberCounter = 1001;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> deleteAccount();
                case 6 -> {
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter Account Holder's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Deposit Amount: ₹");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative!");
            return;
        }

        Account account = new Account(name, accountNumberCounter, initialDeposit);
        accounts.put(accountNumberCounter, account);
        System.out.println("Account created successfully! Your Account Number is: " + accountNumberCounter);
        accountNumberCounter++;
    }

    private static void deposit() {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter Amount to Deposit: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter Amount to Withdraw: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.displayDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void deleteAccount() {
        System.out.print("Enter Account Number to Delete: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }
}

