package array.spiralMatrix;

import java.util.Arrays;

/**
 * @author: anran.ma
 * @created: 2024/6/12
 * @description: 螺旋遍历二维数组 https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/
 **/
public class SM146 {
    public int[] spiralArray(int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return new int[]{};
        }
        int cols = array[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] res = new int[rows * cols];
        int idx = 0, row = 0, col = 0, directionIndex = 0, step = 0;
        while (idx < rows * cols) {
            res[idx++] = array[row][col];
            int nextRow = row + directions[directionIndex][0], nextCol = col + directions[directionIndex][1];
            if (nextRow < step || nextRow >= rows - step || (nextCol < step && directionIndex % 4 != 3) || nextCol >= cols - step) {
                directionIndex = (directionIndex + 1) % 4;
                if (directionIndex == 3) {
                    step++;
                }
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        Arrays.stream(new SM146().spiralArray(array)).forEach(System.out::println);
    }
}
