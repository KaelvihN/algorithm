package array.binarysearch;

/**
 * @author: anran.ma
 * @created: 2024/4/20
 * @description: 二分查找
 **/
public class Bs704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int idx = new Bs704().search(nums, 2);
        System.out.println("idx = " + idx);
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length;
        if (nums[start] > target || nums[end - 1] < target) {
            return -1;
        }
        while (end > start) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            }
            start = nums[mid] > target ? start : mid + 1;
            end = nums[mid] < target ? end : mid;
        }
        return -1;
    }
}
