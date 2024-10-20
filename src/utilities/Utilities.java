package utilities;

import java.util.Scanner;

/**
 * This class is used to store methods for inputting.
 * @author phamm
 */
public class Utilities {

    public static Scanner sc = new Scanner(System.in);
    public static boolean loopMore = true;
    public static String err = "ERROR! Please input again!";

    /**
     * This method allow users to input a String from keyboard.
     * @param msg The announcement when users input data.
     * @return String that users have just input.
     */
    public static String inputAString(String msg) {
        String str = null;
        while (loopMore) {
            try {
                System.out.print(msg);
                str = sc.nextLine().trim().replaceAll("\\s+", " ");
                return str;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return null;
    }

    /**
     * This method allow users to input an integer from keyboard.
     *
     * @param msg The announcement when users input data.
     * @param min The minimum integer that users can input.
     * @return The integer number that users have just input.
     */
    public static int inputAnInteger(String msg, int min) {
        String convert = "";
        int a = 0;

        while (loopMore) {
            try {
                System.out.print(msg);
                convert = sc.nextLine().trim();
                if (convert.isEmpty()) {
                    return 0;
                } else {
                    a = Integer.parseInt(convert);

                    if (a < min) {
                        throw new Exception();
                    }
                    return a;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return 0;
    }

    /**
     *
     * @param msg
     * @param min
     * @param max
     * @return
     */
    public static int inputAnInteger(String msg, int min, int max) {
        String convert = "";
        int a = 0;

        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        while (loopMore) {
            try {
                System.out.print(msg);
                convert = sc.nextLine().trim();
                if (convert.isEmpty()) {
                    return 0;
                } else {
                    a = Integer.parseInt(convert);

                    if (a < min || a > max) {
                        throw new Exception();
                    }
                    return a;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return 0;
    }

    /**
     * This method allow users to input a code from keyboard.
     * @param msg The first announcement when users input data.
     * @return The valid code that users have just input.
     */
    public static String inputCode(String msg, String format) {
        boolean check = false;

        while (loopMore) {
            try {
                System.out.print(msg);
                String id = sc.nextLine().trim();
                check = id.matches(format);

                if (!check || id.isEmpty()) {
                    throw new Exception();
                }

                return id;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return null;
    }

    /**
     * This method is used to generate a unique Product ID when users add a new Product.
     * @param index The current index or count used to generate the ID. It represents the sequential number that will be included in the Product ID.
     * @return valid Item code.
     */
    public static String generateCode(int index, String format) {
        return String.format(format, index); //format: "_%04d"
    }

    /**
     * This method is used to get Item's index from Code. This index will help to update Item's code when users change Item's type.
     * @param code Item's code
     * @return Item's index.
     */
    public static int getIndexCode(String code) {
        String[] spl = code.split("_");
        return Integer.parseInt(spl[spl.length - 1]);
    }
}
