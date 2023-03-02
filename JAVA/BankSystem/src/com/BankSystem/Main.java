package com.BankSystem;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        logo();
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account");

        System.out.print("Name Name: ");
        String userName=sc.nextLine();
        System.out.print("CustomerID: ");
        String customerId=sc.next();
        Accounts ejo = new Accounts(userName, customerId);
        loading();
        ejo.menu();


    }
    public static void loading() throws InterruptedException {
        System.out.print("Loading wait please");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
    }
    public static void logo(){
        String logo = """
                
                     ___      .__   __.  _______  .______       _______        __    ______   ____    ____  ___     \s
                    /   \\     |  \\ |  | |       \\ |   _  \\     |   ____|      |  |  /  __  \\  \\   \\  /   / /   \\    \s
                   /  ^  \\    |   \\|  | |  .--.  ||  |_)  |    |  |__         |  | |  |  |  |  \\   \\/   / /  ^  \\   \s
                  /  /_\\  \\   |  . `  | |  |  |  ||      /     |   __|  .--.  |  | |  |  |  |   \\      / /  /_\\  \\  \s
                 /  _____  \\  |  |\\   | |  '--'  ||  |\\  \\----.|  |____ |  `--'  | |  `--'  |    \\    / /  _____  \\ \s
                /__/     \\__\\ |__| \\__| |_______/ | _| `._____||_______| \\______/   \\______/      \\__/ /__/     \\__\\\s
                                                                                                                    \s
                .______        ___      .__   __.  __  ___      ___                                                 \s
                |   _  \\      /   \\     |  \\ |  | |  |/  /     /   \\                                                \s
                |  |_)  |    /  ^  \\    |   \\|  | |  '  /     /  ^  \\                                               \s
                |   _  <    /  /_\\  \\   |  . `  | |    <     /  /_\\  \\                                              \s
                |  |_)  |  /  _____  \\  |  |\\   | |  .  \\   /  _____  \\                                             \s
                |______/  /__/     \\__\\ |__| \\__| |__|\\__\\ /__/     \\__\\                                            \s
                                                                                                                    \s
                """;
        System.out.println(logo);
    }
}

