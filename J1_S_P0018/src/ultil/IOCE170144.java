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
     * Allow users to enter a string of names, which must be at least two
     * letters long and capitalize only the first letter of each letter
     *
     * @param iMsg Used to announce the input sentence
     * @param iErr Used to report an error when the condition is wrong
     * @return a String name
     */
    public static String getName(String iMsg, String iErr) {
        // Check whether the input is a valid string
        String patternString = "^(?=\\S*\\s)(?=.*[a-zA-Z])([A-Z][a-zA-Z]*\\s*)+$";
        Pattern pattern = Pattern.compile(patternString);
        while (true) {
            try {
                System.out.print(iMsg);
                String s = sc.nextLine();
                Matcher matcher = pattern.matcher(s);
                // Check whether the input is a valid string, with length must not be zero and satisfy the condition of Regular Expression
                if (s.length() == 0 || !matcher.matches()) {
                    throw new Exception();
                }
                return s;
                // Print an error if the input is wrong
            } catch (Exception e) {
                System.out.println(iErr);
            }
        }
    }
}
