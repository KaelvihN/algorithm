package array.binarysearch;

/**
 * @author: anran.ma
 * @created: 2024/5/27
 * @description: 有效的完全平方数
 **/
public class Bs367 {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midVal = (long) mid * mid;
            if (midVal == num) {
                return true;
            } else if (midVal > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = new Bs367().isPerfectSquare(5);
        System.out.println("res = " + res);
    }

}
