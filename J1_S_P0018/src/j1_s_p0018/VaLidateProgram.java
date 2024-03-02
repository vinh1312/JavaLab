/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0018;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class VaLidateProgram {

    /**
     * Input the phone number and check if it matches with the condition.
     */
    public void getPhoneNumber() {
        String phone;
        do {
            phone = IOCE170144.getString("Phone number: ", "The string is empty, please re-enter.");
        } while (checkPhone(phone) == null); // Loop until valid phone number is entered
    }

    /**
     * Check for valid phone number
     *
     * @param phone phone number input
     * @return null if it's not valid or phone number if it is valid
     */
    public String checkPhone(String phone) {
        if (phone.matches(".*[^0-9].*")) { //when phone number is not a number
            System.out.println("Phone number must be number.");
            return null;
        }
        if (phone.length() != 10) { //when phone number is not 10 digits
            System.out.println("Phone number must be 10 digits.");
            return null;
        }
        if (phone.charAt(0) != '0') { //when phone number doesn't begin by 0
            System.out.println("Phone number must be begin by zero.");
            return null;
        }
        return phone;
    }

    /**
     * Input the email and check if it matches with the condition.
     */
    public void getEmail() {
        String mail;
        do {
            mail = IOCE170144.getString("Email: ", "The string is empty, please re-enter.");
        } while (checkEmail(mail) == null); //Loop until valid email is entered
    }

    /**
     * Check for valid email It allows numeric values from 0 to 9 Both uppercase
     * and lowercase letters from a to z are allowed Allowed are underscore “_”,
     * hyphen “-“, and dot “.” Hyphen “-” and dot “.” aren't allowed at the
     * start and end of the domain part Consecutive dots aren't allowed For the
     * local part, a maximum of 64 characters are allowed
     *
     * @param email email inputed
     * @return null if it's not valid or email if it is valid
     */
    public String checkEmail(String email) {
        //1: ^(?=.{1,64}@) check the email address contains at least 1 and up to 64 characters before the @ character.
        //2: [A-Za-z0-9_-]+ check a set of characters allowed in the username portion of an email address. 
        //It includes alphabetic characters (A-Z, a-z), digits (0-9) and underscore (_) and dash (-)
        //3: (\\.[A-Za-z0-9_-]+)* An option to check one or more groups of characters like the one above 
        //(with a period (.) in front) after the username part. For example: john.doe, john.doe.smith.
        //4: The @ character separates the username and domain part of the email address.
        if (!(email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))) { //when email is not valid
            System.out.println("Email must be correct format.");
            return null;
        }
        return email;
    }

    /**
     * Input the date and check if it matches with the condition.
     */
    public void getDate() {
        String date;
        do {
            date = IOCE170144.getString("Date: ", "The string is empty, please re-enter.");
        } while (checkDate(date) == null); // Loop until valid date is entered
    }

    /**
     * Check for valid date
     *
     * @param date date input
     * @return null if it's not valid or date if it is valid
     */
    public String checkDate(String date) {
        if (!(date.matches("\\d{2}/\\d{2}/\\d{4}"))) { // execute when the date is not matches form
            System.out.println("Date to correct format(dd/MM/yyyy)!");
            return null;
        } else { // execute when the date is not matches form dd/MM/yyyy
            try {
                DateFormat df;
                df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false); // When it is in "false" state, it is turned off and does not correct the date automatically
                df.parse(date); // Check if the entered date exists or not
            } catch (ParseException e) {
                System.out.println("Date to correct format(dd/MM/yyyy)!");
                return null;
            }
        }
        return date;
    }
}
