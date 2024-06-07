package array.minSonArray;


/**
 * @author: anran.ma
 * @created: 2024/5/29
 * @description: 长度最小的子数组
 **/
public class MSA209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 初始化
        int slow = 0, fast = 0, sum = nums[0], res = Integer.MAX_VALUE;
        while (fast < nums.length - 1) {
            // 如果sum < target,则快指针向后移动
            if (sum < target) {
                sum += nums[++fast];
            }
            // 如果 sum >= target,则慢指针向后移动
            if (sum >= target) {
                // 判断该长度是否为最小
                res = Math.min(res, fast - slow + 1);
                // 为长度为1可以提前退出
                if (res == 1) {
                    return res;
                }
                sum -= nums[slow];
                slow++;
            }
        }
        // 结尾判断
        while (sum >= target) {
            res = Math.min(res, fast - slow + 1);
            sum -= nums[slow];
            slow++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }

    public static void main(String[] args) {
//        int target = 7;
        int target = 11;
//        int target = 4;
//        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1,1,1,1,1,1,1,1};
        int[] nums = {1, 2, 3, 4, 5};
        int res = new MSA209().minSubArrayLen(target, nums);
        System.out.println("res = " + res);
    }
}
