package array.binarysearch;

/**
 * @author: anran.ma
 * @created: 2024/4/20
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 **/
public class Bs34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] idxs = new Bs34().searchRange(nums, 6);
        for (int idx : idxs) {
            System.out.println(idx);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length;
        if (nums.length == 0 || nums[start] > target || nums[end - 1] < target) {
            return new int[]{-1, -1};
        }
        int idx = -1;
        while (end > start) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                idx = mid;
                break;
            }
            start = nums[mid] > target ? start : mid + 1;
            end = nums[mid] > target ? mid : end;
        }
        if (idx == -1) {
            return new int[]{-1, -1};
        }
        start = idx;
        end = idx;
        while (start > 0 && nums[start] == target) {
            start--;
        }
        while (end < nums.length - 1 && nums[end] == target) {
            end++;
        }
        return new int[]{nums[start] == target ? start : start + 1, nums[end] == target ? end : end - 1};
    }
}
