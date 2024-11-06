package com.flipfit.application;

import java.util.Scanner;

public class FlipfitApp {
    public static void main(String args[])
    {
        Gym
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Flipfit");
        System.out.println("Kindly select your role:");
        System.out.println("1.Gym Owner");
        System.out.println("2.Customer");

        int roleChosen = scanner.nextInt();
        scanner.nextLine();// store newline

        switch (roleChosen) {
            case 1 -> handleGymOwnerActions(scanner);
            case 2 -> handleCustomerActions(scanner);
            default -> System.out.println("Invalid choice. Exiting application.");
        }

        scanner.close();
    }

    private static void handleCustomerActions(Scanner scanner)
    {
        System.out.println("Welcome Customer!");
        System.out.println("Choose your option");
        System.out.println("1.View Slot");
        System.out.println("2.Book Slot");
        System.out.println("3.Cancel Booked Slots");
        System.out.println("4.Update User Info");

        int optionSelected = scanner.nextInt();
        scanner.nextLine();

        switch (optionSelected){
            case 1 -> ViewSlots();
            case 2 -> BookSlots();
            case 3 -> CancelBookedSlot();
            case 4 -> UpdateUserInfo();
            default -> System.out.println("Invalid choice. Exiting application.");
        }

    }

    private static void handleGymOwnerActions(Scanner scanner)
    {
        System.out.println("Welcome Gym Owner");
        System.out.println("Choose your option:");
        System.out.println("1.Update Slots");
        System.out.println("2.View Owned Gyms");
        System.out.println("3.Enroll your gym");
        System.out.println("4.Update Slot");
        System.out.println("5.Update GYM details");
        System.out.println("6.Add Gym")

        int optionSelected = scanner.nextInt();
        scanner.nextLine();

        switch (optionSelected){
            case 1 -> UpdateGymSlots();
            case 2 -> ViewOwnedSlots();
            case 3 -> EnrollGym();
            case 4 -> UpdateAvailableSlots();
            case 5 -> UpdateGymDetails();
            case 6 -> AddGym();
            default -> System.out.println("Invalid choice. Exiting application.");
        }
    }
}