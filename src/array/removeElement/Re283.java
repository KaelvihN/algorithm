package array.removeElement;

/**
 * @author: anran.ma
 * @created: 2024/5/28
 * @description: 移动零
 **/
public class Re283 {

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i++] = temp;
            }
        }
    }


    public static void main(String[] args) {
        /*
          4,2,4,0,0,3,0,5,1,0
          0,1,0,3,12
          0
          0,1,0,3,12
         */
        new Re283().moveZeroes(new int[]{0,1,0,3,12});
    }
}
