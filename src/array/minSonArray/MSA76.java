package array.minSonArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: anran.ma
 * @created: 2024/6/5
 * @description: 最小覆盖子串 https://leetcode.cn/problems/minimum-window-substring/description/
 **/
public class MSA76 {
    public static void main(String[] args) {
        String s = "aa", t = "aa";
        System.out.println(new MSA76().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length()>s.length()){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = map.size(),start = 0 ,end = 0,min=Integer.MAX_VALUE;
        for (int slow = 0, fast = 0; fast < s.length(); fast++) {
            char key = s.charAt(fast);
            Integer value = map.get(key);
            if (value == null) {
                continue;
            }
            if (value==1){
                count--;
            }
            map.put(key, value - 1);
            while (count == 0) {
                if (min > fast - slow+1){
                    min = fast - slow+1;
                    start = slow;
                    end = fast;
                }
                Integer sValue = map.get(s.charAt(slow));
                if (sValue == null) {
                    slow++;
                    continue;
                }
                map.put(s.charAt(slow), sValue + 1);
                if (sValue == 0) {
                    count++;
                }
                slow++;
            }
        }
        return min!=Integer.MAX_VALUE?s.substring(start,end+1):"";
    }
}
