package org.example.EmailApp;

import java.util.Random;
import java.util.Scanner;


public class Email {

    private final String firstName;
    private final String lastName;
    private department department;
    private final String COMPANY = "Popjak";
    private String pwd = randomPwd();
    private int mailboxCapacity = 500;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("User has been created ✅");
        setDepartment();
        System.out.println("Your department is: " + department);
        System.out.println("Your email address is: " + getEmailAddress());
        System.out.println("Password: " + pwd);
    }

    public void showInfo() {
        System.out.println("First name: " + this.firstName +
                "\nLast name: " + this.lastName +
                "\nEmail: " + getEmailAddress() +
                "\nMailbox capacity: " + this.mailboxCapacity + "MB"
        );
    }


    private String getEmailAddress() {
        if (department == null) {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + '@' + COMPANY.toLowerCase() + ".com";
        }
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + '@' + this.department.toString().toLowerCase()
                + "." + COMPANY.toLowerCase() + ".com";
    }

    public department setDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the number of your department\n1️⃣ = SALES\n2️⃣ = DEVELOPMENT\n3️⃣ = ACCOUNTING\nAnything else = contractor (no department)");
        String dep = scanner.next();

        return switch (dep) {
            case "1" -> this.department = org.example.EmailApp.department.SALES;
            case "2" -> this.department = org.example.EmailApp.department.DEVELOPMENT;
            case "3" -> this.department = org.example.EmailApp.department.ACCOUNTING;
            default ->  null;
        };
    }

    private static String randomPwd() {
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@$%!?1234567890".toLowerCase();

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public org.example.EmailApp.department getDepartment() {
        return department;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
}
