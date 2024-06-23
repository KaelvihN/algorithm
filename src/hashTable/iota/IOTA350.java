package hashTable.iota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: anran.ma
 * @created: 2024/6/23
 * @description: 两个数组的交集 II https://leetcode.cn/problems/intersection-of-two-arrays-ii/description/
 **/

public class IOTA350 {

    public static void main(String[] args) {
        // int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] nums1 = {7, 2, 2, 4, 7, 0, 3, 4, 5}, nums2 = {3, 9, 8, 6, 1, 9};
        Arrays.stream(new IOTA350().intersect(nums1, nums2)).forEach(System.out::println);
    }

    /**
     * Hash法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectByHash(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer value = map.get(nums2[i]);
            if (value != null) {
                res.add(nums2[i]);
                if (value == 1) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], value - 1);
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 双指针+排序法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}
