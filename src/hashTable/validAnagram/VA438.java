package hashTable.validAnagram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: anran.ma
 * @created: 2024/6/22
 * @description: 找到字符串中所有字母异位词 https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 **/
public class VA438 {
    public static void main(String[] args) {
        String s = "abacbabc", p = "abc";
        new VA438().findAnagrams(s, p).forEach(System.out::println);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (p.length() > s.length()) {
            return res;
        }
        // 初始化元数据
        int[] template = new int[26];
        for (int i = 0; i < p.length(); i++) {
            template[p.charAt(i) - 'a']++;
        }
        int[] temp = new int[26];
        int slow = 0, fast = 0, count = p.length();
        while (fast < s.length()) {
            // fast对应的字符在p中存在，且在s-f区间中未满足p中该字符的数量
            if (temp[s.charAt(fast) - 'a'] < template[s.charAt(fast) - 'a']) {
                count--;
                temp[s.charAt(fast) - 'a']++;
                // 满足字母异位条件
                if (count == 0) {
                    res.add(slow);
                    temp[s.charAt(slow) - 'a']--;
                    slow++;
                    count++;
                }
                fast++;
            } else {
                // 不满足条件，重置
                if (template[s.charAt(fast) - 'a'] == 0) {
                    // 如果快指针对于的字符在p中不存在，则从下一个字符开始
                    slow = ++fast;
                } else {
                    fast = ++slow;
                }
                temp = new int[26];
                count = p.length();
            }
        }
        return res;
    }

}
