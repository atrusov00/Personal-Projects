
public class RecursionPractice {

    /**
     * Returns the value of x * y, computed via recursive addition.
     * x is added y times. Both x and y are non-negative.
     * @param x non-negative integer multiplicand 1
     * @param y non-negative integer multiplicand 2
     * @return x * y
     */
    public static int recursiveMultiplication(int x, int y) {
           if ( y == 0) return 0;
        return x + recursiveMultiplication(x, y - 1);
    }

    /******************************************************************************/

    /**
     * Reverses a string via recursion.
     * @param s the non-null string to reverse
     * @return a new string with the characters in reverse order
     */
    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }

    /******************************************************************************/

    private static int maxHelper(int[] array, int index, int max) {
        if (index == array.length) {
            return max;
        }
        return maxHelper(array, index + 1, Math.max(max, array[index]));
    }

    /**
     * Returns the maximum value in the array.
     * Uses a helper method to do the recursion.
     * @param array the array of integers to traverse
     * @return the maximum value in the array
     */
    public static int max(int[] array) {
        return maxHelper(array, 0, Integer.MIN_VALUE);
    }

    /******************************************************************************/

    /**
     * Returns whether or not a string is a palindrome, a string that is
     * the same both forward and backward.
     * @param s the string to process
     * @return a boolean indicating if the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() -1 )) return false;
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    /******************************************************************************/

    private static boolean memberHelper(int key, int[] array, int index) {
        if (index == array.length) return false;
        if (array[index] == key) return true;
        return memberHelper(key, array, index + 1);
    }

    /**
     * Returns whether or not the integer key is in the array of integers.
     * Uses a helper method to do the recursion.
     * @param key the value to seek
     * @param array the array to traverse
     * @return a boolean indicating if the key is found in the array
     */
    public static boolean isMember(int key, int[] array) {
        return memberHelper(key, array, 0);
    }

    /******************************************************************************/

    /**
     * Returns a new string where identical chars that are adjacent
     * in the original string are separated from each other by a tilde '~'.
     * @param s the string to process
     * @return a new string where identical adjacent characters are separated
     * by a tilde
     */
    public static String separateIdentical(String s) {
        /** note to self it is spelt separate not seperate, if no usages it is probably because of that */
        if (s.length() <= 1) return s;
        if (s.charAt(0) == s.charAt(1)) return s.charAt(0) + "~" + separateIdentical(s.substring(1));
        return s.charAt(0) + separateIdentical(s.substring(1));
    }
}
