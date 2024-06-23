package hashTable.validAnagram;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: anran.ma
 * @created: 2024/6/20
 * @description: 有效的字母异位词 https://leetcode.cn/problems/valid-anagram/description/
 **/
public class VA242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "rat", t = "car";
        System.out.println(new VA242().isAnagram(s, t));
    }

    /**
     * 数组法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}

