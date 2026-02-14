package Mattrix;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {
    public static void main(String[] args) {
         int[][] mat = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 },
                        { 17, 18, 19, 20 } };
        zigzag(mat);
    }

    private static void zigzag(int[][] mat){
        List<Integer> list = new ArrayList<>();
        int x = 0;
        int col1=1;
        for(int r =0;r < mat.length;r++){
            
            if((r) % 2 == 0){
                int row= r;
                int c = 0;
                while(row >= 0 && c < mat[0].length){
                    list.add(mat[row][c]);
                    row--;c++;
                }
                x = c;
            }
            if(r % 2 != 0){
                int row = 0;
                
                while(x >= 0 && row <= r){
                    list.add(mat[row][x]);
                    row++;x--;
                }
                col1+=2;
            }

        }

        for(int r = 1; r< mat.length;r++){
            if(r % 2 == 0){
                int col = mat[0].length-1;
                int row = r;
                while(col >= 0 && row < mat.length){
                    list.add(mat[row][col]);
                    row++;
                    col--;
                }
                x = col+1;
            }

            if(r % 2 != 0){
                int row= mat.length-1;
                while(x > mat[0].length && row >= r){
                    list.add(mat[row][x]);
                    x++;row--;
                }
            }
        }

        for(int val : list){
            System.out.print(val+",");
        }
    }

}
