package array.removeElement;

import java.util.Arrays;

/**
 * @author: anran.ma
 * @created: 2024/5/29
 * @description:有序数组的平方
 **/
public class Re977 {
    public int[] sortedSquares(int[] nums) {
        int[] temp = new int[nums.length];
        int start = 0, end = nums.length - 1, index = nums.length - 1;
        while (start < end) {
            temp[index--] = Math.abs(nums[start]) > Math.abs(nums[end]) ? nums[start] * nums[start++] : nums[end] * nums[end--];
        }
        temp[index] = nums[start] * nums[start];
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 1, 3, 10};
        int[] res = new Re977().sortedSquares(nums);
        Arrays.stream(res).forEach(s -> System.out.print(s + " "));
    }
}
