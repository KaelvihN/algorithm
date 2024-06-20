package hashTable.validAnagram;

import java.util.HashMap;

/**
 * @author: anran.ma
 * @created: 2024/6/20
 * @description:
 **/
public class VA242 {
    public static void main(String[] args) {

    }

    /**
     * a ASCII 97
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        return s.length() > t.length() ? validateAnagram(s, t) : validateAnagram(t, s);
    }

    public boolean validateAnagram(String longStr, String shortStr) {
        int[] contain = new int[26];
        for (int i = 0; i < longStr.length(); i++) {
            contain[longStr.charAt(i) - 'a']++;
        }
        for (int i = 0; i < shortStr.length(); i++) {
            contain[shortStr.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (contain[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
