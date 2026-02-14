
import java.util.ArrayList;
import java.util.List;

public class LC1326 {
    public static void main(String[] args) {
        int[] a = {3,3,1,1,2,0};
        System.out.println(minTap(a) );
    }

    private static int minTap(int[] a){
        List<int[]> list = new ArrayList<>();
        int[] st = new int[a.length];
        int cnt = 0;
        for(int i = 0;i <a.length;i++){
            int s = Math.max(0, i-a[i]);
            int end = Math.min(a.length-1, i+a[i]);
            st[s] = Math.max(st[s], end);
        }

        // for(int x : st){
        //     System.out.print(x+" : ");
        // }
    
        int end = 0;
        int start = 0;

        for(int i=0;i<a.length;i++){
            
            if(i > start){
                return -1;
            }
            if(i > end){
                cnt++;
                end = start;
            }
             start = Math.max(start, st[i]);
        }

        return cnt;
    }
}
