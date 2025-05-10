/* verifica se una stringa è palindroma */

package Esercitazione2;

import IO.*;
public class StringaPalindroma {
    public static boolean isPalindrome(String str) {
        for (int i=0; i<(str.length()/2); i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String a = "bolob";
        IO.println(isPalindrome(a));
    }
}
