package com.flipfit.application;

import com.flipfit.bean.Gym;
import com.flipfit.business.GymManagerInterface;
import com.flipfit.service.GymManagerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipfitApp {
    public static void main(String args[])
    {
        GymManagerInterface manager = new GymManagerImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the FLIPFIT APP");
        System.out.println("1.Login");
        System.out.println("2.Rgeisteration for GYMCustomer");
        System.out.println("3.Rgeisteration for GYMOwner");
        System.out.println("4.Update Password");
        System.out.println("5.Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){
            case 1:
                System.out.println("Please enter your username:");
                String userName =  scanner.nextLine();
                scanner.nextLine();
                System.out.println("Please enter your Password:");
                String password = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Please enter your Role:");
                System.out.println("1.Choose 1 for Admin:");
                System.out.println("2.Choose 2 for GymOwner:");
                System.out.println("3.Choose 3 for GymCustomer:");
                int roleChosen = scanner.nextInt();
                scanner.nextLine();// store newline

                switch (roleChosen) {
                    case 1 -> handleAdminActions(scanner);
                    case 2 -> handleGymOwnerActions(scanner);
                    case 3 -> handleCustomerActions(scanner);
                    default -> System.out.println("Invalid choice. Exiting application.");
                }
                break;
            case 2:
                System.out.println("You have entered Gym Customer Registeration");
                break;

            case 3:
                System.out.println("You have entered Gym Owner Customer");
                break;

            case 4:
                System.out.println("You have entered Update Password");
                System.out.println("Please enter your username:");
                String userNameForUpdatePassword =  scanner.nextLine();
                scanner.nextLine();
                System.out.println("Please enter your Old Password:");
                String oldPassword = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Please enter your New Password:");
                String newPassword = scanner.nextLine();
                scanner.nextLine();
                updatePassword(scanner,userNameForUpdatePassword,oldPassword,newPassword);
                break;

            default:
                break;
        }
        scanner.close();
    }

    private static void handleCustomerActions(Scanner scanner)
    {
        System.out.println("Welcome Customer!");
        System.out.println("Choose your option");
        System.out.println("1.View Booked Slot");
        System.out.println("2.View Available Slot");
        System.out.println("3.Book Slot");
        System.out.println("4.Cancel Booked Slots");
        System.out.println("5.Update User Info");

        int optionSelected = scanner.nextInt();
        scanner.nextLine();

        switch (optionSelected){
            case 1 -> ViewBookedSlots();
            case 2 -> ViewAvailableSlots();
            case 2 -> BookSlots();
            case 3 -> CancelBookedSlot();
            case 4 -> UpdateUserInfo();
            default -> System.out.println("Invalid choice. Exiting application.");
        }

    }

    private static void handleGymOwnerActions(Scanner scanner,GymManagerInterface manager)
    {
        System.out.println("Welcome Gym Owner");
        System.out.println("Choose your option:");
        System.out.println("1.Update Slots");
        System.out.println("2.View Owned Gyms");
        System.out.println("3.Enroll your gym");
        System.out.println("4.Update GYM details");
        int optionSelected = scanner.nextInt();
        scanner.nextLine();
        Gym managerOwnedGyms = new Gym();
        switch (optionSelected){
            case 1 -> manager.updateSlot();
            case 2 -> manager.viewOwnedGyms();
            case 3 -> manager.enrollGym(managerOwnedGyms);
            case 4 -> manager.updatedGymDetails(managerOwnedGyms);
            default -> System.out.println("Invalid choice. Exiting application.");
        }
    }

    private static void handleAdminActions(Scanner scanner)
    {
        System.out.println("Welcome Customer!");
        System.out.println("Choose your option");
        System.out.println("1.Add User");
        System.out.println("2.Add GymOwner");

        int optionSelected = scanner.nextInt();
        scanner.nextLine();

        switch (optionSelected){
            case 1 -> AddUser();
            case 2 -> AddGymOwner();
            default -> System.out.println("Invalid choice. Exiting application.");
        }

    }

}