package array.removeElement;

/**
 * @author: anran.ma
 * @created: 2024/5/27
 * @description:移除元素
 **/
public class Re27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        /**
         * {0,1,2,2,3,0,4,2}
         * 2
         */
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int res = new Re27().removeElement(nums, val);
        System.out.println("res = " + res);
    }
}
