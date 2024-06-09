package array.spiralMatrix;

/**
 * @author: anran.ma
 * @created: 2024/6/9
 * @description: 螺旋矩阵 II https://leetcode.cn/problems/spiral-matrix-ii/description/
 **/
public class SM59 {
    /**
     * 逐层处理
     * @param n
     * @return
     */
        public int[][] generateMatrixOld(int n) {
        int[][] res = new int[n][n];
        int temp = 1, x = 0, y = 0, flag = 1;
        for (; n > 0; n -= 2, x++, y++) {
            for (int i = 0; i < 4 * (n - 1) || flag * n == 1; i++) {
                if (n == 1) {
                    flag = -1;
                }
                if (i < n - 1 || n == 1) {
                    res[x][y++] = temp++;
                } else if (i < 2 * (n - 1)) {
                    res[x++][y] = temp++;
                } else if (i < 3 * (n - 1)) {
                    res[x][y--] = temp++;
                } else {
                    res[x--][y] = temp++;
                }
            }
        }
        return res;
    }

    /**
     * 顺时针旋转
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= n * n) {
            matrix[row][column] = curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = new SM59().generateMatrix(3);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
