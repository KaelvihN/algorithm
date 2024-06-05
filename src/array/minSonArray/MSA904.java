package array.minSonArray;

/**
 * @author: anran.ma
 * @created: 2024/6/5
 * @description: 水果成篮
 **/
public class MSA904 {
    public static void main(String[] args) {
//        int[] fruits = {1, 2, 1};
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println(new MSA904().totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        int slow = 0, fast = 0, mid = 0;
        int temp = fruits[0], result = 1;
        while (fast < fruits.length - 1) {
            // 在两种的情况之内
            if (fruits[fast] == fruits[slow] || fruits[fast] == temp) {
                // 更新最大数
                result = Math.max(result, fast - slow + 1);
                // 判断中间指针是否需要位移
                while (fruits[fast] != fruits[mid]) {
                    mid++;
                }
                temp = fruits[fast] == fruits[slow] ? temp : fruits[fast];
                fast++;
            } else {
                temp = fruits[fast];
                slow = mid;
            }
        }
        return fruits[fast] == fruits[slow] || fruits[fast] == temp || fruits[slow] == temp ?
                Math.max(result, fast - slow + 1) : result;
    }
}
