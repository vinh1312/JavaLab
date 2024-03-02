/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class Dictionary {

    /**
     * Private HashMap to store the dictionary entries. The keys are of type
     * String and represent the words in the dictionary. The values are also of
     * type String and represent the corresponding definitions of the words.
     */
    private HashMap<String, String> myDictionary;

    /**
     * Constructor for the Dictionary class. Initializes a new instance of the
     * class and creates a HashMap to store the dictionary entries.
     */
    public Dictionary() {
        myDictionary = new HashMap<>();
    }

    /**
     * Reads flower information from a file.
     *
     * @param fileName The name of the file to read from.
     */
    public void readFromFile(String fileName) {
        // Create a new File object with the given file name
        File file = new File(fileName);
        try {
            // Create a new Scanner object to read from the file
            Scanner sc = new Scanner(file);
            // Read the first line of the file, which contains the number of vocabulary in the file
            int n = Integer.parseInt(sc.nextLine().trim());
            // Loop through the remaining lines in the file and parse vocabulary from each line
            for (int i = 0; i < n; i++) {
                // Split the line by ":" to extract the vocabulary
                String[] data = sc.nextLine().split("[\\:]");
                // Parse the vocabulary from the string hash map
                String vocabulary = data[0].trim();
                String meaning = data[1].trim();
                // Put a new vocabulary with the parsed information and add it to the myDictionary
                myDictionary.put(vocabulary, meaning);
            }
            System.out.println("The file has been loaded successfuly!");
        } catch (FileNotFoundException e) {
            // If the file is not found, print an error message
            System.out.println("Error: file not found! Please check again.\n");
        }
    }

    /**
     * Writes flower information to a file.
     *
     * @param fileName The name of the file to write to.
     */
    public void writeToFile(String fileName) {
        try {
            // Create a new FileWriter and PrintWriter object to write to the file
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            // Write the number of vocabulary in the list as the first line of the file
            pw.println(myDictionary.size());
            // Loop through the myDictionary and write the vocalbulary to the file
            for (String key : myDictionary.keySet()) {
                pw.println(key + ": " + myDictionary.get(key));
            }
            // Close the PrintWriter
            pw.close();
            System.out.println("The file has been written successfully!");
        } catch (IOException e) {
            // If there is an error while writing to the file, print an error message
            System.out.println("Error: Something went wrong while writing to the file, please check and try again!\n" + e.getMessage());
        }
    }

    /**
     * Displays the menu options for the Dictionary program and prompts the user
     * to select a function.
     *
     * @return The selected function as an integer.
     */
    public int menu() {
        System.out.println("======== Dictionary program ========");
        System.out.println("1. Add word");
        System.out.println("2. Delete word");
        System.out.println("3. Translate");
        System.out.println("4. Exit");
        return IOCE170144.getInteger(">Select function: ", "Error: Choose from 1 to 4, please try again!", 1, 4);
    }

    /**
     * Adds a new vocabulary entry to the dictionary. Prompts the user to enter
     * an English word and checks if it already exists in the dictionary. If the
     * word already exists, it provides an option to replace the existing entry
     * with a new one. If the word doesn't exist, it prompts the user to enter
     * the corresponding Vietnamese word. Updates the dictionary accordingly.
     */
    public void addVocabulary() {
        System.out.println("------------- Add ----------");
        // Prompt the user to enter the English word
        String vocabulary = IOCE170144.getString("Enter English: ", "Error: The English word can't be empty!");
        // Check if the word already exists in the dictionary
        boolean checkVoca = checkTheExistenceOfVocabulary(vocabulary);

        if (checkVoca) {
            System.out.println("Caution: The English word already exists!");
            // Prompt the user to choose whether to replace the existing entry
            String option = IOCE170144.getYesOrNo("Do you want to replace(Y/N): ", "Error: You must enter 'Y' or 'N'!");
            if (option.equalsIgnoreCase("y")) {
                // Get the key corresponding to the existing word
                String lexicon = getKeySetAlreadyExited(vocabulary);
                // Prompt the user to enter the Vietnamese word to be updated
                String means = IOCE170144.getString("Enter Vietnamese to update the meaning: ", "The Vietnamese word can't be empty!");
                // Replace the existing entry with the new one
                myDictionary.put(lexicon, means);
                System.out.println("Updated word successfully!");
            }
        } else {
            // Prompt the user to enter the corresponding Vietnamese word
            String meaning = IOCE170144.getString("Enter Vietnamese: ", "The Vietnamese word can't be empty!");
            // Add the new word and its meaning to the dictionary
            myDictionary.put(vocabulary, meaning);
            System.out.println("Added new word successfully!");
        }
    }

    /**
     * Removes a vocabulary entry from the dictionary. Prompts the user to enter
     * an English word to remove from the dictionary. If the dictionary is
     * empty, it displays a message indicating that there is nothing to delete.
     * If the word exists in the dictionary, it removes the corresponding entry.
     * If the word doesn't exist, it displays a message indicating that the word
     * doesn't exist in the dictionary.
     */
    public void removeVocabulary() {
        System.out.println("------------ Delete ---------------");
        // Check if the dictionary is empty
        if (myDictionary.isEmpty()) {
            System.out.println("Caution: List is empty, nothing to delete!");
        } else {
            // Prompt the user to enter the English word to remove
            String vocabulary = IOCE170144.getString("Enter the english word you want to remove: ", "Error: The English word can't be empty!");
            // Check if the word exists in the dictionary
            boolean checkVoca = checkTheExistenceOfVocabulary(vocabulary);

            if (checkVoca) {
                // Iterate through the dictionary entries
                for (String key : myDictionary.keySet()) {
                    // Check if the current entry's key matches the entered vocabulary
                    if (key.equalsIgnoreCase(vocabulary)) {
                        // Remove the vocabulary entry from the dictionary
                        myDictionary.remove(key);
                        System.out.println("Vocabulary has been removed successfully!");
                        break;
                    }
                }
            } else {
                System.out.println("Caution: " + vocabulary + " doesn't exist, please try again.");
            }
        }
    }

    /**
     * Translates an English word to its corresponding Vietnamese meaning.
     * Prompts the user to enter an English word to translate. If the dictionary
     * is empty, it displays a message indicating that there is nothing to find.
     * If the word exists in the dictionary, it displays the corresponding
     * Vietnamese meaning. If the word doesn't exist, it displays a message
     * indicating that the word is not found in the dictionary.
     */
    public void translate() {
        System.out.println("------------- Translate -----------");
        // Check if the dictionary is empty
        if (myDictionary.isEmpty()) {
            System.out.println("Caution: List is empty, nothing to find!");
        } else {
            // Prompt the user to enter the word to translate
            String vocabulary = IOCE170144.getString("Enter the word you want to translate: ", "Error: The English word can't be empty!");
            // Check if the word exists in the dictionary
            boolean checkVoca = checkTheExistenceOfVocabulary(vocabulary);

            if (checkVoca) {
                // Iterate through the dictionary entries
                for (String key : myDictionary.keySet()) {
                    // Check if the current entry's key matches the entered vocabulary
                    if (key.equalsIgnoreCase(vocabulary)) {
                        // Display the corresponding Vietnamese meaning
                        System.out.println("Vietnamese: " + myDictionary.get(key));
                        break;
                    }
                }
            } else {
                System.out.println("Caution: Not found in data.");
            }
        }
    }

    /**
     * Checks the existence of a vocabulary entry in the dictionary.
     *
     * @param vocabulary The English word to check.
     * @return True if the word exists in the dictionary, false otherwise.
     */
    public boolean checkTheExistenceOfVocabulary(String vocabulary) {
        for (String key : myDictionary.keySet()) {
            if (key.equalsIgnoreCase(vocabulary)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the key (English word) that already exists in the dictionary.
     *
     * @param vocabulary The English word to search for.
     * @return The key (English word) that matches the provided word in the
     * dictionary, or null if not found.
     */
    public String getKeySetAlreadyExited(String vocabulary) {
        for (String key : myDictionary.keySet()) {
            if (key.equalsIgnoreCase(vocabulary)) {
                return key;
            }
        }
        return null;
    }
}
