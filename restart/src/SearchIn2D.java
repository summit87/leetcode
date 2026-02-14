public class SearchIn2D {
    public static void main(String[] args) {
        int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 31;
        System.out.println(isExist(mat, target));
    }

    private static boolean isExist(int[][] mat,int target){
        int left = 0;
        int row = mat.length;
        int col = mat[0].length;
        int right = (row*col)-1;
        while(left <= right){
            int mid = (left+right) >> 1;
            if(mat[mid/col][mid % col] == target){
                return true;
            }

            if(mat[mid/col][mid % col] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
