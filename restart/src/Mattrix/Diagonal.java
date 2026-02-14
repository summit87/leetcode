package Mattrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: mat[][] = [[ 1, 2, 3, 4 ],
 * [5, 6, 7, 8 ],
 * [9, 10, 11, 12],
 * [13, 14, 15, 16],
 * [17, 18, 19, 20]]
 * Output: 1 5 2 9 6 3 13 10 7 4 17 14 11 8 18 15 12 19 16 20
 */
public class Diagonal {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 },
                        { 17, 18, 19, 20 } };
        traversal(mat);
    }

    private static void traversal(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            int col = 0;
            int r = row;
            while (col < matrix[0].length && r >= 0) {
                list.add(matrix[r][col]);
                r--;
                col++;
            }
        }

        int b = 0;
        for (int col = 1; col < matrix[0].length; col++) {
            int c = col;
            int r = matrix.length - 1;
            b++;
            while (c < matrix[0].length && r >= b) {
                list.add(matrix[r][c]);
                r--;
                c++;
            }
        }

        for (int x : list) {
            System.out.print(x + ",");
        }
    }
}
