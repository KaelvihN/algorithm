package array.binarysearch;

/**
 * @author: anran.ma
 * @created: 2024/4/20
 * @description: 搜索插入位置
 **/
public class Bs35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int res = new Bs35().searchInsert(nums, 2);
        System.out.println("res = " + res);
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length, mid = (end - start) / 2 + start;
        if (nums[start] > target) {
            return 0;
        }
        if (nums[end - 1] < target) {
            return end;
        }

        while (end > start) {
            if (nums[mid] == target || (nums[mid-1] < target && target < nums[mid])) {
                return mid;
            }
            mid = (end - start) / 2 + start;
            start = nums[mid] > target ? start : mid + 1;
            end = nums[mid] < target ? end : mid;
        }
        return mid;
    }
}
