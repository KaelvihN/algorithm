package hashTable.validAnagram;

import java.util.*;

/**
 * @author: anran.ma
 * @created: 2024/6/22
 * @description: 找到字符串中所有字母异位词 https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 **/
public class VA49 {

    /**
     * 数组+Hash
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> container = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[26];
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (chars[i] == 0) {
                    continue;
                }
                sb.append((char) ('a' + i)).append(chars[i]);
            }
            List<String> elements = container.getOrDefault(sb.toString(), new ArrayList<>());
            elements.add(str);
            container.put(sb.toString(), elements);
        }
        return new ArrayList<>(container.values());
    }

    /**
     * 排序+Hash法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> container = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String formatStr = new String(chars);
            List<String> elements = container.getOrDefault(formatStr, new ArrayList<>());
            elements.add(str);
            container.put(formatStr, elements);
        }
        return new ArrayList<>(container.values());
    }
}
