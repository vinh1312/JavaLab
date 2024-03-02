/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0014;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class UserDataBase {

    private ArrayList<User> userData;

    /**
     * Constructor for UserDataBase class Initializes the userData ArrayList
     */
    public UserDataBase() {
        userData = new ArrayList<>();
    }

    /**
     * Load users from a file into the userData ArrayList
     *
     * @param fileName The name of the file to load users from
     */
    public void loadUsers(String fileName) {
        File file = new File(fileName);
        try {
            //Create a Scanner object to read from the file file.
            Scanner sc = new Scanner(file);
            int n = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < n; i++) {
                //Reads the next line from the file, contains the username,
                //password and assigns the value to the variable username and password.
                String username = sc.nextLine().trim();
                String password = sc.nextLine().trim();
                userData.add(new User(username, password));
            }
            System.out.println("FILE has been read successfully.");
        } catch (Exception e) {
            System.out.println("An error occured!!!");
        }
    }

    /**
     * Save users from the userData ArrayList into a file
     *
     * @param fileName The name of the file to save users to
     */
    public void saveUsers(String fileName) {
        try {
            //Creates a FileWriter object to write data to a file with the name specified by the fileName variable.
            FileWriter fw = new FileWriter(fileName);
            //Creates a PrintWriter object to write formatting data to the FileWriter fw object. 
            //This PrintWriter object will help us write data to the file more conveniently.
            PrintWriter pw = new PrintWriter(fw);
            //Writes the number of users in the userData ArrayList to a file
            //using the PrintWriter object's println() method. This will create
            //a new line in the file and write userData.size() as the number of
            //users on that line.
            pw.println(userData.size());
            for (User u : userData) {
                pw.print(u.getUsername() + "\r\n");
                pw.print(u.getPassword() + "\r\n");
            }
            pw.close();
            System.out.println("FILE has been recorded successfully.");
        } catch (Exception e) {
            System.out.println("An error ocurred!!");
        }
    }

    /**
     *
     * @return the selected menu option.
     */
    public int menu() {
        System.out.println("===== USER MANAGEMENT SYSTEM =====");
        System.out.println("1. Create new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
        System.out.println("----------------------------------");
        return IOCE170144.getInteger("> Choose: ", "Function only 1 to 3, please try again", 1, 3);
    }

    /**
     * Add a new user to the userData ArrayList
     */
    public void addUsers() {
        //Force the user to enter a username until it doesn't match the list
        String username = IOCE170144.getUserInfo("Enter user name: ", "Invalid username. "
                + "It must be at least 5 characters long and contain no spaces.", 5);
        boolean check = checkNewUser(username);
        if (check == true) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            String password = IOCE170144.getUserInfo("Enter password: ", "Invalid password. "
                    + "It must be at least 6 characters long and contain no spaces.", 6);
            userData.add(new User(username, password));
            System.out.println("Account created successfully.");
        }
    }

    /**
     * Check if a username already exists in the userData ArrayList
     *
     * @param username The username to check
     * @return true if the username already exists, false otherwise
     */
    public boolean checkNewUser(String username) {
        for (User u : userData) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Perform login system
     */
    public void loginSystem() {
        String username = IOCE170144.checkUserLogin("Enter user name: ", "Invalid username. "
                + "It must be at least 5 characters long and contain no spaces.", 5);
        if (username != null) {
            String password = IOCE170144.checkUserLogin("Enter password: ", "Invalid password. "
                    + "It must be at least 6 characters long and contain no spaces.", 6);
            if (password != null) {
                //Check if username and password match or not.
                boolean checkLogin = login(username, password);
                if (checkLogin == false) {
                    System.out.println("Username or password is wrong, please try again!");
                } else {
                    System.out.println("Login successful.");
                }
            }
        }
    }

    /**
     * Check if a username and password combination is valid for login
     *
     * @param username The username to check
     * @param password The password to check
     * @return true if the combination is valid, false otherwise
     */
    public boolean login(String username, String password) {
        for (User u : userData) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
