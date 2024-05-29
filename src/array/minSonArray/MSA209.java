package array.minSonArray;

import java.util.Arrays;

/**
 * @author: anran.ma
 * @created: 2024/5/29
 * @description:
 **/
public class MSA209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, idx = nums.length - 1;
        Arrays.sort(nums);
        for (; idx > 0; idx--) {
            sum += nums[idx];
            if (sum >= target) {
                break;
            }
        }
        return sum >= target ? nums.length - idx : 0;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = new MSA209().minSubArrayLen(target, nums);
        System.out.println("res = " + res);
    }
}
