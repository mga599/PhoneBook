package com.mahmoudgamal;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Mahmoud Gamal on 12/9/2016.
 * Email mga599@gmail.com
 * Website http;//www.mahmoudgamal.com
 * Github http://www.github.com/mga599
 */

public class AppMenu {
    /**
     * Create an instance of Contacts
     * Create an instance of Scanner
     * Initialize variables
     */
    private static Contacts contacts = new Contacts();
    private static Scanner input = new Scanner(System.in);
    private static int menu;
    public static boolean isRunning = true;
    private static String oldPhoneNumber;

    /**
     * Initialize our menu to console screen
     */
    public static void initialize(){
        /**
         * Print menu to user
         */
        System.out.println("Choose from menu: \n 1- Add contact " +
                "\n 2- Get contact by phone number"+
                "\n 3- Update contact"+
                "\n 4- Delete a contact"+
                "\n 5- Display all contacts"+
                "\n 6- Exit");
        /**
         * Get user input request
         */
        menu = input.nextInt();

        /**
         * Cases based on user input request
         */
        switch (menu){
            case 1:
                addContactMenu();
                break;
            case 2:
                getContactByPhoneNumberMenu();
                break;
            case 3:
                updateContactMenu();
                break;
            case 4:
                removeContactMenu();
                break;
            case 5:
                displayAllContactsMenu();
                break;
            case 6:
                isRunning = false;
                break;
            default:
                System.out.println("Sorry i can't recognize your request");
                break;
        }


    }

    /**
     * Display all contacts screen
     */
    private static void displayAllContactsMenu() {
        if (contacts.getContactsSize() > 0){
            System.out.println("You have "+ contacts.getContactsSize() +" Contacts");
            Iterator keys = contacts.getAllContacts();



                for (int i = 0; i < contacts.getContactsSize(); i++){
                    if (keys.hasNext()) {
                        Object key = keys.next();
                        displayContact((String) key);
                    }
                }
        } else
            System.out.println("Sorry your contact list is empty");

    }


    /**
     * Remove contact screen
     */
    private static void removeContactMenu() {
        phoneNumberDialogue();
        if (contacts.checkIfPhoneNumberExist(contacts.getPhoneNumber())) {
            deleteContact(contacts.getPhoneNumber());
            System.out.println("Contact deleted successfully");
        } else
            System.out.println("Sorry phone number not found");
    }

    /**
     * Delete contact from HashMap based on phone number as key
     * @param phoneNumber
     */
    private static void deleteContact(String phoneNumber) {
        contacts.deleteContact(phoneNumber);
    }

    /**
     * Add contact screen
     */
    private static void addContactMenu(){
        phoneNumberDialogue();
        if (contacts.checkIfPhoneNumberExist(contacts.getPhoneNumber()))
            System.out.println("Sorry phone number added before");
        else {

            addContactDialogue();

            saveContact();
        }
    }

    /**
     * Save contact into HashMap
     */
    private static void saveContact() {
        contacts.addContact(contacts.getFirstName(),
                contacts.getLastName(),
                contacts.getEmail(),
                contacts.getPhoneNumber());
    }


    /**
     * Get contact by phone number screen
     */
    private static void getContactByPhoneNumberMenu(){
        phoneNumberDialogue();
        if (contacts.checkIfPhoneNumberExist(contacts.getPhoneNumber()))
            displayContact(contacts.getPhoneNumber());
        else
            System.out.println("Phone number not exist");
    }

    /**
     * Display contact on screen
     * @param phoneNumber String phone number as key
     */
    private static void displayContact(String phoneNumber){
        String values[] = contacts.getContactByPhoneNumber(phoneNumber);
        System.out.println(" First Name: "+values[0]
                +"\n Last Name: "+values[1]
                +"\n Email: "+values[2]+"\n Phone number: "+ phoneNumber +"\n");
    }

    /**
     * Enter phone number screen
     */
    private static void phoneNumberDialogue(){
        System.out.println("Enter Phone Number: ");
        contacts.setPhoneNumber(input.next());
    }

    /**
     * New phone number screen
     */
    private static void newPhoneNumberDialogue(){
        System.out.println("Enter a new Phone Number: ");
        oldPhoneNumber = contacts.getPhoneNumber();
        contacts.setPhoneNumber(input.next());
    }

    /**
     * Add contact details screen
     */
    private static void addContactDialogue(){
        System.out.println("Enter First Name: ");
        contacts.setFirstName(input.next());

        System.out.println("Enter Last Name: ");
        contacts.setLastName(input.next());

        System.out.println("Enter Email: ");
        contacts.setEmail(input.next());
    }

    /**
     * Update contact screen
     */
    private static void updateContactMenu(){
        phoneNumberDialogue();
        if (contacts.checkIfPhoneNumberExist(contacts.getPhoneNumber())) {
            displayContact(contacts.getPhoneNumber());
            newPhoneNumberDialogue();
            addContactDialogue();
            saveContact();
            deleteContact(oldPhoneNumber);
        } else
            System.out.println("Sorry phone number doesn't exist");
    }
}
