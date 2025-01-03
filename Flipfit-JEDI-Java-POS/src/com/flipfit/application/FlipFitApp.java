package com.flipfit.application;

import com.flipfit.bean.*;
import com.flipfit.business.AdminInterface;
import com.flipfit.business.CustomerInterface;
import com.flipfit.business.GymManagerInterface;
import com.flipfit.business.SlotInterface;
import com.flipfit.dao.*;
import com.flipfit.service.AdminImpl;
import com.flipfit.service.CustomerImpl;
import com.flipfit.service.GymManagerImpl;
import com.flipfit.service.SlotImpl;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class FlipFitApp {
    public static void main(String args[]) {
        GymManagerInterface manager = new GymManagerImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the FLIP FIT APP");
        System.out.println("1.Login");
        System.out.println("2.Registration for GYMCustomer");
        System.out.println("3.Registration for GYMOwner");
        System.out.println("4.Exit");

        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                System.out.println("Please enter your Role:");
                System.out.println("1.Choose 1 for Admin:");
                System.out.println("2.Choose 2 for GymOwner:");
                System.out.println("3.Choose 3 for GymCustomer:");
                int roleChosen = scanner.nextInt();
                CustomerInterface customer = new CustomerImpl();
                GymManagerInterface gymManager = new GymManagerImpl();
                AdminInterface admin = new AdminImpl();
                switch (roleChosen) {
                    case 1 -> {
                        System.out.println("Please enter your admin username:");
                        String adminUsername = scanner.nextLine();
                        adminUsername = scanner.nextLine();
                        System.out.println("Please enter your password:");
                        String passwordForAdmin = scanner.nextLine();
                        LoginInterface adminLogin = new AdminDAO();
                        String id = adminLogin.login(adminUsername, passwordForAdmin);
                        if( id != null ) {
                            handleAdminActions(scanner, admin);
                        }
                        else{
                            System.out.println("Invalid admin username or password");
                        }
                    }
                    case 2 -> {
                        System.out.println("Please enter your manager id:");
                        String mangerId = scanner.nextLine();
                        mangerId = scanner.nextLine();
                        System.out.println("Please enter your password:");
                        String passwordForManager = scanner.nextLine();
                        LoginInterface managerLogin = new FlipfitGymManagerDAO();
                        String id = managerLogin.login(mangerId, passwordForManager);
                        if(id != null) {
                            handleGymOwnerActions(scanner, gymManager, mangerId);
                        }
                        else{
                            System.out.println("Invalid managerId or password");
                        }
                    }
                    case 3 -> {
                        System.out.println("Please enter your username:");
                        String customerUserName = scanner.nextLine();
                        customerUserName = scanner.nextLine();
                        System.out.println("Please enter your password:");
                        String passwordForUser = scanner.nextLine();
                        LoginInterface userLogin = new UserDAO();
                        String id = userLogin.login(customerUserName, passwordForUser);
                        if( id != null) {
                            handleCustomerActions(scanner, customer, id);
                        }
                        else {
                            System.out.println("Invalid username or password");
                        }
                        break;
                    }
                    default -> System.out.println("Invalid choice. Exiting application.");
                }
                break;
            case 2:
                UserDAO userDAO = new UserDAO();
                User user = new User();
                System.out.println("You have entered Gym Customer Registration");
                System.out.println("Please enter your username:");
                user.setUserName(scanner.nextLine());
                user.setUserName(scanner.nextLine());
                System.out.println("Please enter your email:");
                user.setEmail(scanner.nextLine());
                System.out.println("Please enter your Password:");
                user.setPassword(scanner.nextLine());
                System.out.println("Please enter your first name:");
                user.setLastName(scanner.nextLine());
                System.out.println("Please enter your last name:");
                user.setFirstName(scanner.nextLine());
                System.out.println("Please enter your phone number:");
                user.setUserPhone(scanner.nextLine());
                System.out.println("Please enter your body weight:");
                user.setUserWeight(scanner.nextDouble());
                userDAO.createUser(user.userName(), user.email(), user.password(), user.firstName(), user.lastName(), user.getUserPhone(), user.getUserWeight());
                break;
            case 3:
                AdminDAO adminDAO = new AdminDAO();
                GymManager gymManagerp = new GymManager();
                System.out.println("You have entered Gym Manager Registration");
                System.out.println("Please enter your username:");
                gymManagerp.setUserName(scanner.nextLine());
                gymManagerp.setUserName(scanner.nextLine());
                System.out.println("Please enter your email:");
                gymManagerp.setEmail(scanner.nextLine());
                System.out.println("Please enter your password:");
                gymManagerp.setPassword(scanner.nextLine());
                System.out.println("Please enter your first name:");
                gymManagerp.setFirstName(scanner.nextLine());
                System.out.println("Please enter your last name:");
                gymManagerp.setLastName(scanner.nextLine());
                System.out.println("Please enter gym id:");
                String gymId = scanner.nextLine();
                adminDAO.addGymManager(gymManagerp.userName(),gymManagerp.email(),gymManagerp.password(),gymManagerp.firstName(),gymManagerp.lastName(),gymId);
                break;
            default:
                break;
        }
        scanner.close();
    }

    private static void handleCustomerActions(Scanner scanner, CustomerInterface customer,String id)
    {
        System.out.println("Welcome Customer!");
        System.out.println("Choose your option");
        System.out.println("1.View Booked Slot");
        System.out.println("2.Cancel Booked Slots");
        System.out.println("3.Update User Info");

        int optionSelected = scanner.nextInt();
        scanner.nextLine();

        switch (optionSelected){
            case 1 -> customer.viewBookedSlots(id);
            case 2 ->{
                System.out.println("Enter your slot id: ");
                String slotId = scanner.nextLine();
                scanner.nextLine();
                customer.cancelSlot(id,slotId);
            }
            case 3 -> {
                System.out.println("What do you want to update?");
                System.out.println("1.Phone number");
                System.out.println("2.Email address");
                System.out.println("3.Password");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Enter Phone Number");
                        String phoneNumber = scanner.nextLine();
                        customer.updateUserInfo(id,phoneNumber,null,null);
                        break;
                    case 2:
                        System.out.println("Enter Email Address");
                        String emailAddress =  scanner.nextLine();
                        customer.updateUserInfo(id,null,emailAddress,null);
                        break;
                    case 3:
                        System.out.println("Enter Password");
                        String password =  scanner.nextLine();
                        customer.updateUserInfo(id,null,null,password);
                        break;
                }
            }
            default -> System.out.println("Invalid choice. Exiting application.");
        }

    }

    private static void handleGymOwnerActions(Scanner scanner,GymManagerInterface manager,String id)
    {
        System.out.println("Welcome Gym Owner");
        System.out.println("Choose your option:");
        System.out.println("1.View Owned Gyms");
        System.out.println("2.Enroll your gym");
        System.out.println("3.Add a slot for the gym");
        System.out.println("4.Update Password");

        int optionSelected = scanner.nextInt();
        switch (optionSelected) {
            case 1 -> manager.viewOwnedGyms(id);
            case 2 -> {
                Gym managerOwnedGyms = new Gym();
                System.out.println("Enter your gym id: ");
                String managerOwnedGymId = scanner.nextLine();
                managerOwnedGymId = scanner.nextLine();
                managerOwnedGyms.setGymId(managerOwnedGymId);
                manager.enrollGym(managerOwnedGyms, id);
                break;
            }
            case 3 -> {
                SlotInterface slotImpl = new SlotImpl();
                System.out.println("Enter your Gym id for which you want to enter a slot: ");
                String managerOwnedGymId = scanner.nextLine();
                managerOwnedGymId = scanner.nextLine();
                System.out.println("Enter date for the slot in (format: yyyy-MM-dd):");
                String dateInput = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date sqlDate = null;
                try {
                    java.util.Date utilDate = dateFormat.parse(dateInput);
                    sqlDate = new Date(utilDate.getTime());
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please try again.");
                }
                System.out.println("Enter start time for the slot: ");
                String startTime = scanner.nextLine();
                System.out.println("Enter available seats for the slot: ");
                int availableSeats = scanner.nextInt();
                System.out.println("Enter training for the slot: ");
                String training = scanner.nextLine();
                training = scanner.nextLine();
                Slot slot = new Slot("",managerOwnedGymId,startTime,sqlDate,availableSeats,training);
                slotImpl.addSlot(slot);
            }
            case 4 -> {
                System.out.println("You have entered Update Password");
                System.out.println("Please enter your username:");
                String userNameForUpdatePassword = scanner.nextLine();
                userNameForUpdatePassword = scanner.nextLine();
                System.out.println("Please enter your Old Password:");
                String oldPassword = scanner.nextLine();
                System.out.println("Please enter your New Password:");
                String newPassword = scanner.nextLine();
                //update password for gym owner
                manager.updatePassword(userNameForUpdatePassword,oldPassword,newPassword);
            }
            default -> System.out.println("Invalid choice. Exiting application.");
        }
    }

    private static void handleAdminActions(Scanner scanner, AdminInterface admin)
    {
        System.out.println("Welcome Admin!");
        System.out.println("Choose your option");
        System.out.println("1.View all users");
        System.out.println("2.Add region");
        System.out.println("3.Add gym");
        System.out.println("4.Update password");

        int optionSelected = scanner.nextInt();
        scanner.nextLine();

        switch(optionSelected){
            case 1 -> {
                List<User> users = admin.getUserList();
                for(User user:users){
                    System.out.println("User ID:" + user.id() + "User Name:" + user.userName());
                }
            }
            case 2 -> {
            AdminDAO adminDAO = new AdminDAO();
            Region region = new Region();
            System.out.println("Enter your region name:");
            region.setRegionName(scanner.nextLine());
            adminDAO.addRegion(region.regionName());
            }
            case 3 -> {
            System.out.println("Enter region id:");
            String regionId = scanner.nextLine();
            System.out.println("Enter postal code:");
            int pincode = scanner.nextInt();
            admin.addGym(regionId, pincode);
            }
            case 4 -> {
                System.out.println("You have entered Update Password");
                System.out.println("Please enter your username:");
                String userNameForUpdatePassword = scanner.nextLine();
                System.out.println("Please enter your New Password:");
                String newPassword = scanner.nextLine();
                //update password for admin
                admin.updateAdminPassword(userNameForUpdatePassword,newPassword);
            }
            default -> System.out.println("Invalid choice. Exiting application.");
        }

    }
}