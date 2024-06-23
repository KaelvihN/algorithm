package hashTable.iota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: anran.ma
 * @created: 2024/6/23
 * @description: 两个数组的交集 https://leetcode.cn/problems/intersection-of-two-arrays/description/
 **/
public class IOTA349 {
    public static void main(String[] args) {
        // int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        // int[] nums1 = {4,7,9,7,6,7}, nums2 = {5,0,0,6,1,6,2,2,4};
        // Arrays.stream(new IOTA349().intersection(nums1,
        // nums2)).forEach(System.out::println);
        System.out.println(1 ^ 1);
    }

    /**
     * hash法
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectionHash(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> container = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            container.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (container.contains(nums2[i])) {
                container.remove(nums2[i]);
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 双指针法
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1 = 0, idx2 = 0;
        while (true) {
            if (nums1[idx1] == nums2[idx2]) {
                res.add(nums1[idx1]);
                idx1 = findNext(idx1, nums1);
                idx2 = findNext(idx2, nums2);
                if (idx1 == -1 || idx2 == -1) {
                    break;
                }
            } else {
                boolean flag = nums1[idx1] > nums2[idx2];
                idx1 = flag ? idx1 : moveIdx(nums2[idx2], idx1, nums1);
                idx2 = !flag ? idx2 : moveIdx(nums1[idx1], idx2, nums2);
                if (idx1 == -1 || idx2 == -1) {
                    break;
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 寻找和tagert相等或这比其大的节点
     * 
     * @param tagert
     * @param idx
     * @param nums
     * @return
     */
    public int moveIdx(int tagert, int idx, int[] nums) {
        while (idx < nums.length && nums[idx] < tagert) {
            idx++;
        }
        return idx < nums.length ? idx : -1;
    }

    /**
     * 寻找下一个不重复的节点
     * 
     * @param idx
     * @param nums
     * @return
     */
    public int findNext(int idx, int[] nums) {
        idx++;
        while (idx < nums.length && nums[idx] == nums[idx - 1]) {
            idx++;
        }
        return idx < nums.length ? idx : -1;
    }
}
