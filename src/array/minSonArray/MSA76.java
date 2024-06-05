package array.minSonArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: anran.ma
 * @created: 2024/6/5
 * @description: 最小覆盖子串
 **/
public class MSA76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MSA76().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            set.add(t.charAt(i));
        }
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            if (!map.isEmpty()) {
                Integer times = map.get(s.charAt(fast));
                if (times != null) {
                    times -= 1;
                    if (times == 0) {
                        map.remove(s.charAt(fast));
                    } else {
                        map.put(s.charAt(fast), times);
                    }
                }
                fast++;
            } else {
                res = s.substring(slow, fast).length() < res.length() || res.isEmpty() ? s.substring(slow, fast) : res;
                if (set.contains(s.charAt(slow))) {
                    map.put(s.charAt(slow), 1);
                }
                slow++;
            }
        }
        return res;
    }
}
