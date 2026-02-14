public class SearchInSortedAndRotatedArray {
    public static void main(String[] args) {
        
    }

    public static int search(int[] a,int left,int right,int target){
        if(left > right){
            return -1;
        }

        if(a[left] == target){
            return left;
        }

        if(a[right] == target){
            return right;
        }

        int mid = (left+right) >> 1;

        if(a[mid] == target){
            return mid;
        }

        if(a[mid] > a[left]){
            if(target > a[left] && target <a[mid]){
                return search(a, left, mid-1, target);
            }
            return search(a, mid+1, right, target);
        }

        if(target <= a[right] && target > a[mid] ){
            return search(a, mid+1, right, target);
        }
        return search(a, left, mid-1, target);
    }
}
