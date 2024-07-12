/* 
 * File Name: Application.java
 * Student Name: Tehreem Sajid
 * Submission Date: July 7th, 2024
 * Lab 2 Code for Exercise 5
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {
	// Stored all instances created by the program in lists for updating purposes, but in reality they
	// would be stored in text files so that they don't reset every time the program is run this would also make deletion operations easier
    private static List<Client> allClients = new ArrayList<>();
    private static List<Pet> allPets = new ArrayList<>();
    private static List<Booking> allBookings = new ArrayList<>();
    private static List<Billing> allBillings = new ArrayList<>();
    private static List<Payment> allPayments = new ArrayList<>();
    
    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the YYC Pet Resort Application! \nPlease enter the letter corresponding to your answers for the following questions"
                    + " \nWhat would you like to see: \nA.Manage Clients \nB.Manage Pets \nC.Bookings and Reservations \nD.Billings and Payments \nE.Exit");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("e")) {
                System.out.println("Exiting application...");
                break;
            }

            switch (choice.toLowerCase()) {
                case "a":
                    manageClients(scanner);
                    break;
                case "b":
                    managePets(scanner);
                    break;
                case "c":
                    manageBookings(scanner);
                    break;
                case "d":
                    manageBillingsAndPayments(scanner);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
    
    // Function to deal with client instances
    public static void manageClients(Scanner scanner) {
        System.out.println("Would you like to \nA. Add a new client \nB. Update an existing Client");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
        	// case a creates a client
            case "a":
                System.out.println("Please enter the full name of the new client");
                String fullName = scanner.nextLine();
                System.out.println("Please enter the phone number of the new client");
                String phoneNumber = scanner.nextLine();
                System.out.println("Please enter the address of the new client");
                String address = scanner.nextLine();
                Client newClient = new Client(fullName, phoneNumber, address);
                allClients.add(newClient);
                System.out.println("The new client has been added");
                break;
            // case b updates a client
            case "b":
                System.out.println("Please enter the full name of the client you wish to update:");
                String clientName = scanner.nextLine();
                boolean clientFound = false;
                for (Client client : allClients) {
                    if (client.getFullName().equalsIgnoreCase(clientName)) {
                        clientFound = true;
                        System.out.println("What field would you like to update \nA. Name \nB. Phone Number \nC. Address");
                        String choice2 = scanner.nextLine();
                        switch (choice2.toLowerCase()) {
                            case "a":
                                System.out.println("Please enter the new full name of the client");
                                String newFullName = scanner.nextLine();
                                client.setFullName(newFullName);
                                System.out.println("The name has been updated");
                                break;
                            case "b":
                                System.out.println("Please enter the new phone number of the client");
                                String newPhoneNumber = scanner.nextLine();
                                client.setPhoneNumber(newPhoneNumber);
                                System.out.println("The phone number has been updated");
                                break;
                            case "c":
                                System.out.println("Please enter the new address of the client");
                                String newAddress = scanner.nextLine();
                                client.setAddress(newAddress);
                                System.out.println("The address has been updated");
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    }
                }
                // If client is not found in the list of all clients then error message appears
                if (!clientFound) {
                    System.out.println("Client does not exist. Please choose to add client instead of update");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    
    // Function to deal with Pet instances
    public static void managePets(Scanner scanner) {
        System.out.println("Would you like to \nA. Add a new pet \nB. Update an existing pet");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
        	// Case a creates a new pet
            case "a":
            	System.out.println("Please enter the full name of the owner of the new pet");
                String ownerName = scanner.nextLine();
                // for loop checks if client exists (this code is reused multiple times throughout the program)
                boolean clientFound = false;
                for (Client client : allClients) {
                    if (client.getFullName().equalsIgnoreCase(ownerName)) {
                        clientFound = true;
                        System.out.println("Please enter the name of the new pet");
		                String name = scanner.nextLine();
		                System.out.println("Please enter whether the new pet is a cat or dog");
		                String type = scanner.nextLine();
		                System.out.println("Please enter the breed of the new pet");
		                String breed = scanner.nextLine();
		                System.out.println("Please enter the age of the new pet");
		                int age = scanner.nextInt();
		                scanner.nextLine();
                        System.out.println("Now we need to create a care profile for the pet. Please enter the feeding instructions of the pet");
                        String feedingInstruction = scanner.nextLine();
                        System.out.println("Please enter the medication instructions of the pet");
                        String medicationInstruction = scanner.nextLine();
                        System.out.println("Please enter the medication list of the pet");
                        String medicationList = scanner.nextLine();
                        CareProfile careProfile = new CareProfile(feedingInstruction, medicationInstruction, medicationList);
                        Pet newPet = new Pet(name, type, breed, age, client, careProfile);
                        allPets.add(newPet);
                        System.out.println("Your pet has been added");
                    }
                }
                if (!clientFound)
                    System.out.println("This client does not exist. Please add the client first and then the pet");
                break;
            // case b updates a pet
            case "b":
                System.out.println("Please enter the full name of the pet you wish to update:");
                String petName = scanner.nextLine();
                boolean petFound = false;
                for (Pet pet : allPets) {
                    if (pet.getName().equalsIgnoreCase(petName)) {
                        petFound = true;
                        System.out.println("What field would you like to update \nA.Name \nB.Age \nC.Owner \nD.Care Profile");
                        String choice2 = scanner.nextLine();
                        switch (choice2.toLowerCase()) {
                            case "a":
                                System.out.println("Please enter the new full name of the pet");
                                String newFullName = scanner.nextLine();
                                pet.setName(newFullName);
                                System.out.println("The name has been updated");
                                break;
                            case "b":
                                System.out.println("Please enter the new age of the pet");
                                int newAge = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                pet.setAge(newAge);
                                System.out.println("The age has been updated");
                                break;
                            case "c":
                                System.out.println("Please enter the new owner of the pet");
                                String newOwner = scanner.nextLine();
                                boolean newOwnerFound = false;
                                for (Client client : allClients) {
                                    if (client.getFullName().equalsIgnoreCase(newOwner)) {
                                        pet.setOwner(client);
                                        newOwnerFound = true;
                                        System.out.println("The owner has been updated");
                                        break;
                                    }
                                }
                                if (!newOwnerFound) {
                                    System.out.println("This client does not exist. Please add the client first and then update the pet");
                                }
                                break;
                            case "d":
                                CareProfile careProfile = pet.getCareProfile();
                                System.out.println("Would you like to update: A.feeding instructions, B.medical instructions C.medication list");
                                String choice3 = scanner.nextLine();
                                switch (choice3.toLowerCase()) {
                                    case "a":
                                        System.out.println("Please enter the new feeding instructions of the pet");
                                        String newFeedingInstructions = scanner.nextLine();
                                        careProfile.setFeedingInstructions(newFeedingInstructions);
                                        System.out.println("The feeding instructions have been updated");
                                        break;
                                    case "b":
                                        System.out.println("Please enter the new medical instructions of the pet");
                                        String newMedicalInstructions = scanner.nextLine();
                                        careProfile.setMedicationInstructions(newMedicalInstructions);
                                        System.out.println("The medical instructions have been updated");
                                        break;
                                    case "c":
                                        System.out.println("Please enter the new medication list of the pet");
                                        String newMedicationList = scanner.nextLine();
                                        careProfile.setMedicationList(newMedicationList);
                                        System.out.println("The medication list has been updated");
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                }
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    }
                }
                if (!petFound) {
                    System.out.println("Pet does not exist. Please choose to add pet instead of update");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    
    // Function to manage booking instances
    public static void manageBookings(Scanner scanner) {
        System.out.println("Would you like to \nA. Create a new booking \nB. Update an existing booking");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
        	// case a is to add a booking
            case "a":
                System.out.println("Please enter the name of the pet the booking is for");
                String petName = scanner.nextLine();
                boolean petFound = false;
                for (Pet pet : allPets) {
                    if (pet.getName().equalsIgnoreCase(petName)) {
                        petFound = true;
		                System.out.println("Please enter the booking number");
		                String bookingNumber = scanner.nextLine();
		                System.out.println("Please enter the booking date");
		                String date = scanner.nextLine();
		                System.out.println("Please enter the booking details");
		                String bookingDetails = scanner.nextLine();
                        Booking newBooking = new Booking(bookingNumber, date, pet, bookingDetails);
                        allBookings.add(newBooking);
                        System.out.println("New booking created");
                        break;
                    }
                }
                if (!petFound) {
                    System.out.println("The pet you are trying to book for does not exist");
                }
                break;
            // case b is to update a booking
            case "b":
                System.out.println("Please enter the booking number of the booking you wish to update:");
                String updateBookingNumber = scanner.nextLine();
                boolean bookingFound = false;
                for (Booking booking : allBookings) {
                    if (booking.getBookingNumber().equalsIgnoreCase(updateBookingNumber)) {
                        bookingFound = true;
                        System.out.println("What field would you like to update \nA.Booking Number \nB.Date \nC.Pet \nD.Details");
                        String choice2 = scanner.nextLine();
                        switch (choice2.toLowerCase()) {
                            case "a":
                                System.out.println("Please enter the new booking number");
                                String newBookingNumber = scanner.nextLine();
                                booking.setBookingNumber(newBookingNumber);
                                System.out.println("The booking number has been updated");
                                break;
                            case "b":
                                System.out.println("Please enter the new date of the booking");
                                String newDate = scanner.nextLine();
                                booking.setDate(newDate);
                                System.out.println("The date has been updated");
                                break;
                            case "c":
                                System.out.println("Please enter the full name of the new pet");
                                String newPet = scanner.nextLine();
                                boolean newPetFound = false;
                                for (Pet pet : allPets) {
                                    if (pet.getName().equalsIgnoreCase(newPet)) {
                                        booking.setPet(pet);
                                        newPetFound = true;
                                        System.out.println("The pet has been updated");
                                        break;
                                    }
                                }
                                if (!newPetFound) {
                                    System.out.println("The pet you wish to book for does not exist");
                                }
                                break;
                            case "d":
                                System.out.println("Please enter the new booking details");
                                String newBookingDetails = scanner.nextLine();
                                booking.setBookingDetails(newBookingDetails);
                                System.out.println("The booking details have been updated");
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    }
                }
                if (!bookingFound) {
                    System.out.println("Booking does not exist. Please choose to add booking instead of update");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    
    // Function to deal with Billing and Payment instances
    public static void manageBillingsAndPayments(Scanner scanner) {
        System.out.println("Would you like to \nA. Create a new billing \nB. Add a payment");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
        	// case a is to create a billing
            case "a":
            	System.out.println("Please enter the booking number of the booking the billing is for");
                String bookingNumber = scanner.nextLine();
                boolean bookingFound = false;
                for (Booking booking : allBookings) {
                    if (booking.getBookingNumber().equals(bookingNumber)) {
                        bookingFound = true;
                        System.out.println("Please enter the name of the client the billing is for");
                        String clientName = scanner.nextLine();
                        boolean clientFound = false;
                        for (Client client : allClients) {
                            if (client.getFullName().equalsIgnoreCase(clientName)) {
                                clientFound = true;
                                System.out.println("Please enter the billing number");
                                String billingNumber = scanner.nextLine();
                                System.out.println("Please enter the billing amount");
                                String billingAmount = scanner.nextLine();
                                Billing newBilling = new Billing(billingNumber, client, booking, billingAmount);
                                allBillings.add(newBilling);
                                System.out.println("New billing created");
                            }
                        }
                        if (!clientFound) {
                            System.out.println("The client you are trying to create a billing for doesn't exist");
                        }
                    }               
                }
                if (!bookingFound) {
                    System.out.println("The booking you are trying to create a billing for doesn't exist");
                }
                break;
            // case b is to add a payment: we assume cash payments aren't excepted so all payment amount is always equal to billing amount
            case "b":
                System.out.println("Please enter the billing number this payment is for");
                String billingNumber2 = scanner.nextLine();
                boolean billingFound = false;
                for (Billing billing : allBillings) {
                    if (billing.getBillingNumber().equals(billingNumber2)) {
                        billingFound = true;
                        System.out.println("Please enter the name of the client who made this payment");
                        String clientName = scanner.nextLine();
                        boolean clientFound = false;
                        for (Client client : allClients) {
                            if (client.getFullName().equalsIgnoreCase(clientName)) {
                                clientFound = true;
                                Payment newPayment = new Payment(billing, client);
                                allPayments.add(newPayment);
                                System.out.println("New Payment created");
                            }
                        }
                        if (!clientFound) {
                            System.out.println("The client you are trying to add a payment for doesn't exist");
                        }
                    }
                }
                if (!billingFound) {
                    System.out.println("The billing you are trying to create a payment for doesn't exist");
                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}


