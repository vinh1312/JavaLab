/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0014;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class User {

    private String username; // User's username

    private String password; // User's password

    /**
     * Default constructor for the User class.
     */
    public User() {
    }

    /**
     * Constructor with username and password parameters to initialize a new
     * User.
     *
     * @param username User's username
     * @param password User's password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter method to retrieve the value of the username property.
     *
     * @return The value of the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method to set the value of the username property.
     *
     * @param username The new value for the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method to retrieve the value of the password property.
     *
     * @return The value of the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method to set the value of the password property.
     *
     * @param password The new value for the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
