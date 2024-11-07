package com.flipfit.application;

import com.flipfit.bean.Gym;
import com.flipfit.bean.User;
import com.flipfit.business.AdminInterface;
import com.flipfit.business.CustomerInterface;
import com.flipfit.business.GymManagerInterface;
import com.flipfit.dao.UserDAO;
import com.flipfit.service.AdminImpl;
import com.flipfit.service.CustomerImpl;
import com.flipfit.service.GymManagerImpl;

import java.util.Scanner;

public class FlipFitApp {
    public static void main(String args[]) {
        GymManagerInterface manager = new GymManagerImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the FLIP FIT APP");
        System.out.println("1.Login");
        System.out.println("2.Registration for GYMCustomer");
        System.out.println("3.Registration for GYMOwner");
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
                CustomerInterface customer = new CustomerImpl();
                GymManagerInterface gymManager = new GymManagerImpl();
                AdminInterface admin = new AdminImpl();
                switch (roleChosen) {
                    case 1 -> handleAdminActions(scanner,admin);
                    case 2 -> handleGymOwnerActions(scanner, gymManager);
                    case 3 -> handleCustomerActions(scanner, customer);
                    default -> System.out.println("Invalid choice. Exiting application.");
                }
                break;
            case 2:
                UserDAO userDAO = new UserDAO();
                User user = new User();
                System.out.println("You have entered Gym Customer Registration");
                System.out.println("Please enter your username:");
                user.setUserName(scanner.nextLine());
                System.out.println("Please enter your email:");
                user.setEmail(scanner.nextLine());
                System.out.println("Please enter your Password:");
                user.setPassword(scanner.nextLine());
                System.out.println("Please enter your first name:");
                user.setLastName(scanner.nextLine());
                System.out.println("Please enter your last name:");
                user.setFirstName(scanner.nextLine());
                userDAO.createUser(user.userName(), user.email(), user.password(), user.firstName(), user.lastName());
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
                //updatePassword(scanner,userNameForUpdatePassword,oldPassword,newPassword);
                break;

            default:
                break;
        }
        scanner.close();
    }

    private static void handleCustomerActions(Scanner scanner, CustomerInterface customer)
    {
        System.out.println("Welcome Customer!");
        System.out.println("Choose your option");
        System.out.println("1.View Booked Slot");
        System.out.println("2.View Available Slot");
        System.out.println("3.Cancel Booked Slots");
        System.out.println("4.Update User Info");

        int optionSelected = scanner.nextInt();
        scanner.nextLine();

        switch (optionSelected){
            case 1 -> customer.viewBookedSlots();
            case 2 -> customer.viewUserPlan();
            case 3 -> customer.cancelSlot();
            case 4 -> customer.updateUserInfo();
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

    private static void handleAdminActions(Scanner scanner, AdminInterface admin)
    {
        System.out.println("Welcome Customer!");
        System.out.println("Choose your option");
        System.out.println("1.Add User");
        System.out.println("2.Add GymOwner");

        int optionSelected = scanner.nextInt();
        scanner.nextLine();

        switch (optionSelected){
            case 1 -> admin.addUser();
            case 2 -> admin.addGymOwner();
            default -> System.out.println("Invalid choice. Exiting application.");
        }

    }

}