package array.minSonArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: anran.ma
 * @created: 2024/6/5
 * @description: 最小覆盖子串 https://leetcode.cn/problems/minimum-window-substring/description/
 **/
public class MSA76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MSA76().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = map.size();
        String res = "";
        for (int slow = 0, fast = 0; fast < s.length(); fast++) {
            char key = s.charAt(fast);
            Integer value = map.get(key);
            if (value == null) {
                continue;
            }
            map.put(key, value - 1);
            count--;
            while (count == 0) {
                res = fast - slow + 1 < res.length() || res.isEmpty() ? s.substring(slow, fast + 1) : res;
                Integer sValue = map.get(s.charAt(slow));
                if (sValue == null) {
                    continue;
                }
                map.put(s.charAt(slow), sValue + 1);
                if (sValue == 0) {
                    count++;
                }
            }
        }
        return res;
    }
}
