package ultil;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class IOCE170144 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Allows the user to enter an integer, if the condition is wrong, an error
     * will be reported
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return an integer
     */
    public static int getInteger(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                // Used to convert String to Integer number
                int a = Integer.parseInt(sc.nextLine());
                return a;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }
    //overload

    /**
     * Allows the user to enter an integer in the range of their choice, if the
     * condition is wrong, an error will be reported
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @param start is the smallest integer range
     * @param end is the largest integer range
     * @return an integer
     */
    public static int getInteger(String iMsg, String iErr, int start, int end) {
        // If the user intentionally enters a number with the beginning greater than the ending number
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        while (true) {
            try {
                System.out.print(iMsg);
                // Used to convert String to Integer number
                int a = Integer.parseInt(sc.nextLine());
                // If the input number is out of the allowed range
                if (a < start || a > end) {
                    throw new Exception();
                }
                return a;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allows the user to enter a real number, if the condition is wrong, an
     * error will be reported
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a real number
     */
    public static double getDouble(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                // Used to convert String to Real number
                double a = Double.parseDouble(sc.nextLine());
                return a;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allows the user to enter a real number in the range of their choice, if
     * the condition is wrong, an error will be reported
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @param start is the smallest real number range
     * @param end is the largest real number range
     * @return a real number
     */
    public static double getDouble(String iMsg, String iErr, double start, double end) {
        // If the user intentionally enters a number with the beginning greater than the ending number
        if (start > end) {
            double temp = start;
            start = end;
            end = temp;
        }
        while (true) {
            try {
                System.out.print(iMsg);
                // Used to convert String to Real number
                double a = Double.parseDouble(sc.nextLine());
                // If the input number is out of the allowed range
                if (a < start || a > end) {
                    throw new Exception();
                }
                return a;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow the user to enter a string and check if the string is empty, it
     * will give an error
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a String
     */
    public static String getString(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                String s = sc.nextLine();
                // Check whether the string is empty
                if (s.trim().length() == 0) {
                    throw new Exception();
                }
                return s.trim();
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow the user to enter a string and check if the string is less than the
     * given integer, it will give an error
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @param t
     * @return a String
     */
    public static String getString(String iMsg, String iErr, int t) {
        while (true) {
            try {
                System.out.print(iMsg);
                String s = sc.nextLine();
                // Check whether the string is less than the given integer
                if (s.trim().length() < t) {
                    throw new Exception();
                }
                return s.trim();
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow users to enter a string of names, which must be at least two
     * letters long and capitalize only the first letter of each letter
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a String name
     */
    public static String getName(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                String name = sc.nextLine();

                if (name.trim().length() == 0) {
                    System.out.println("Error: The name can't be empty!");
                    continue; // Skip the rest of the loop and ask the user to re-enter
                }
                if (!(name.matches("^[a-zA-Z].+") || name.matches("^[a-zA-Z]"))) { // When the name doesn't begin by a a to z or A to Z
                    System.out.println("Error: The name must begin with a character from a to z or A to Z!");
                    continue; // Repeat while loop to ask for name again
                }
                if (!(name.matches("^[a-zA-Z0-9. ]{1,256}$"))) { // When the name have a character which is not from a to z, A to Z or 0 to 9 and the point
                    System.out.println("Error: The name cannot have special characters!");
                    continue;
                }
                if (name.matches(".+ \\..*") || name.matches(".+\\.\\w.*") || name.matches(".+\\.\\..*") || name.charAt(name.length() - 1) == '.') {
                    System.out.println("Error: The \".\" must be attached to the letter before and followed by a space!");
                    continue;
                }
                if (name.matches(".+  .*")) {
                    System.out.println("Error: Cannot have more than one space in the name!");
                    continue;
                }
                return name;
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow the user to enter a string and check if the string is empty or
     * contain unknown character like @$@%^, it will give an error
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a String
     */
    public static String getLocationWork(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                String s = sc.nextLine();
                // // Check whether the string contains only letters, digits, and spaces
                if (s.trim().length() == 0 || !s.matches("[a-zA-Z0-9\\s]+")) {
                    throw new Exception();
                }
                return s.trim();
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }
}
