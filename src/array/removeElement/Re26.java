package array.removeElement;

/**
 * @author: anran.ma
 * @created: 2024/5/28
 * @description: 删除排序数组中的重复项
 **/
public class Re26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            } else {
                fast++;
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        //1,1,2
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = new Re26().removeDuplicates(nums);
        System.out.println("res = " + res);
    }
}
