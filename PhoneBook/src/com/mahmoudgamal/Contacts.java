package com.mahmoudgamal;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Mahmoud Gamal on 12/9/2016.
 * Email mga599@gmail.com
 * Website http;//www.mahmoudgamal.com
 * Github http://www.github.com/mga599
 */

public class Contacts {

    /**
     * Initialize variables
     *  @param firstName String First Name
     *  @param lastName String Last Name
     *  @param email String Email address
     *  @param phoneNumber String Phone Number
     */
    private String firstName, lastName, email, phoneNumber;

    /**
     * Initialize HashMap it's type of ArrayList with index key
     * generics phoneNumber as key , String array as Values
     */
    private HashMap<String, String[]> contacts = new  HashMap<String, String[]>();


    /**
     * Default constructor
     * Initialize default values
     */
    public Contacts(){
        contacts.put("01023", new String[] {"Mahmoud", "Gamal", "mga599@gmail.com"});
        contacts.put("01140", new String[] {"Yehia", "Osama", "yehia@mahmoudgamal.com"});
    }

    /**
     * Get first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set first name
     * @param firstName String first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last name
     * @param lastName String last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get email address
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set first name
     * @param email String email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number
     * @param phoneNumber String phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Add a contzct to HashMap (contacts)
     * @param firstName String first name
     * @param lastName String last name
     * @param email String email address
     * @param phoneNumber String phone number
     */
    public void addContact (String firstName, String lastName, String email, String phoneNumber){
        this.contacts.put(phoneNumber, new String[]{firstName, lastName, email});
    }

    /**
     * Get contzct from HashMap based on phone number as key
     * @param phoneNumber String phone number
     * @return values as array of contzct details
     */
    public String[] getContactByPhoneNumber (String phoneNumber){
            return this.contacts.get(phoneNumber);
    }

    /**
     * Check if phone number exist based on phone number as key
     * @param phoneNumber String phone number
     * @return boolean
     */
    public boolean checkIfPhoneNumberExist(String phoneNumber){
        if (this.contacts.containsKey(phoneNumber))
            return true;
        else
            return false;
    }

    /**
     * Delete contact based on phone number as key
     * @param phoneNumber String phone number
     */
    public void deleteContact (String phoneNumber){
        this.contacts.remove(phoneNumber);
    }

    /**
     * Return iterator of values in HashMap
     * @return Iterator
     */
    public Iterator<String> getAllContacts(){
        return this.contacts.keySet().iterator();
    }

    /**
     * Get count of contacts in HashMap
     * @return int
     */
    public int getContactsSize (){
        return this.contacts.size();
    }
}
