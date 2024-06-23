package hashTable.hn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: anran.ma
 * @created: 2024/6/23
 * @description: 快乐数 https://leetcode.cn/problems/happy-number/description/
 **/
public class HN202 {
    public static void main(String[] args) {
        System.out.println("new HN202().isHappy(2) = " + new HN202().isHappy(19));
    }

    Set<Integer> contains = new HashSet<>();
    boolean flag = false;

    public boolean isHappy(int n) {
        int idx = 0, res = 0;
        String temp = String.valueOf(n);

        while (idx < temp.length()) {
            res += (int) Math.pow(temp.charAt(idx)-'0', 2);
            idx++;
        }
        if (contains.contains(res)) {
            return false;
        } else if (res == 1) {
            flag = true;
            return true;
        } else {
            contains.add(res);
            isHappy(res);
        }
        return flag;
    }
}
