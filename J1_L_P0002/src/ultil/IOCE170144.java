package ultil;

import java.util.Scanner;

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
                return s;
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
                return s;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow the user to enter a name and check the condition of the name, it
     * will give an error
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
                if (name.matches(".+ \\..*") || name.matches(".+\\.\\w.*") || name.matches(".+\\.\\..*") || name.charAt(name.length() - 1) == '.') { // Execute when the "." is wrong
                    System.out.println("Error: The \".\" must be attached to the letter before and followed by a space!");
                    continue;
                }
                if (name.matches(".+  .*")) { // The string have a double space
                    System.out.println("Error: Cannot have more than one space in the name!");
                    continue;
                }
                if (name.matches(".+[a-zA-Z][a-zA-Z]\\..*")) { // Execute when the name like "AB."
                    System.out.println("Error: Cannot have more than a character before the point!");
                    continue;
                }
                if (!(name.contains(" ") || name.contains("."))) { // Execute when the name have only one word
                    System.out.println("Error: Name must have more than a word!");
                    continue;
                }
                if (!name.matches("^([A-Za-z]{1}[a-zA-Z0-9]{0,})(((([ ]{1}|[.]{1}[ ]{1}|[.]{1})[A-Za-z]{1}[a-zA-Z0-9]{0,}[.]{0,})|[-]{1}[a-zA-Z]{1,}[.]{0,}){1,})$")) { // Check for another case
                    System.out.println("Error: Name is invalid!");
                    continue;
                }
                return name;
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow the user to enter a string and check if the string does not contain
     * "Y" or "N", it will throw an notification
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a String
     */
    public static String getYesOrNo(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                String s = sc.nextLine();
                // Check whether the string does not contain "Y" or "N"
                if (!(s.trim().equalsIgnoreCase("y") || s.trim().equalsIgnoreCase("n"))) {
                    throw new Exception();
                }
                return s;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow the user to enter a string and check if the string does not contain
     * "U" or "D", it will throw an notification
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a String
     */
    public static String getUpdateOrDelete(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                String s = sc.nextLine();
                // Check whether the string does not contain "U" or "D"
                if (!(s.trim().equalsIgnoreCase("u") || s.trim().equalsIgnoreCase("d"))) {
                    throw new Exception();
                }
                return s;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow the user to enter semester and check if it is valid
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a String
     */
    public static String getSemester(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                String semester = sc.nextLine();

                if (semester.trim().length() == 0) {
                    System.out.println("Error: The semester can't be empty!");
                    continue; // Skip the rest of the loop and ask the user to re-enter
                }

                if (!(semester.matches("^[a-zA-Z].+") || semester.matches("^[a-zA-Z]"))) { // When the name doesn't begin by a a to z or A to Z
                    System.out.println("Error: Semester must be begin by a character from a to z or from A to Z");
                    continue;
                }

                if (!(semester.matches("^[a-zA-Z0-9. -]{1,256}$"))) { // When the name have a character which is not from a to z, A to Z or 0 to 9 and the point
                    System.out.println("Error: Semester can't have speacial character!");
                    continue;
                }

                if (semester.matches(".+  .*")) { // the string have a double space
                    System.out.println("Error: Cannot have more than a space in semester!");
                    continue;
                }
                return semester;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow user to input student ID and check if it is valid
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return an ID
     */
    public static String getCode(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                String code = sc.nextLine();

                if (code.trim().length() == 0) {
                    System.out.println("Error: The ID can't be empty!");
                    continue; // Skip the rest of the loop and ask the user to re-enter
                }

                if ((code.matches("^[0-9].*"))) { // When the code doesn't begin by a to z or A to Z or 0 to 9
                    System.out.println("Error: ID must be begin by a character from a to z or from A to Z");
                    continue;
                }
                if (!(code.matches("^[a-zA-Z0-9]{1,256}$"))) { // When the code have a character which is not from a to z, A to Z or 0 to 9 and the point
                    System.out.println("Error: ID can't have speacial character or space!");
                    continue;
                }
                return code;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }

    /**
     * Allow the user to enter a string and check if the string is correct or
     * not, it will throw an notification
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a course
     */
    public static String getCourse(String iMsg, String iErr) {
        while (true) {
            try {
                System.out.print(iMsg);
                String s = sc.nextLine();

                if (s.trim().equalsIgnoreCase("java")) { //check input course in java
                    return "Java";

                } else if (s.trim().equalsIgnoreCase(".net")) { //check input course in .net
                    return ".Net";

                } else if (s.trim().equalsIgnoreCase("c/c++")) { //check input course in c/c++
                    return "C/C++";

                } else { // When the input is emply or not the same with three of these courses
                    throw new Exception();
                }
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }
}
