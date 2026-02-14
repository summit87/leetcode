
import java.util.ArrayList;
import java.util.List;

public class LC300 {
    public static void main(String[] args) {
        int[] a = { 4,10,4,3,8,9};
        // System.out.println(binary(a, 0, a.length-1));
        // int cnt = 0;
        // for(int i=0;i<a.length;i++){
        // cnt = Math.max(cnt, binary(a, 0, i));
        // }
        // System.out.println(cnt);
        System.out.println(list(a));
    }

    private static int list(int[] a) {
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for (int num : a) {
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            }else{
                int index = binarySearch(list, num);
                System.out.println(index);
                list.set(index, num);
            }
        }
        return list.size();
    }

    public static int binarySearch(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if(list.get(mid) == num){
                return mid;
            }
            if (list.get(mid) > num) {
                right = mid ;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
