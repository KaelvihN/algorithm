package hashTable.validAnagram;

/**
 * @author: anran.ma
 * @created: 2024/6/20
 * @description: 赎金信 https://leetcode.cn/problems/ransom-note/description/
 **/
public class VA383 {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] container = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            container[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            container[idx]--;
            if (container[idx] < 0) {
                return false;
            }
        }
        return true;
    }
}
