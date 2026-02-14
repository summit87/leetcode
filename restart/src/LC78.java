
import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subset(a, 0, res, list);
        for(List<Integer> li : subset1(a)){
            for(Integer i : li){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    private static void subset(int[] a,int index,List<List<Integer>> res,List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = index;i < a.length;i++){
            list.add(a[i]);
            subset(a, i+1, res, list);
            list.remove(list.size()-1);
        }
    }

    private static List<List<Integer>> subset1(int[] a){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i < Math.pow(2, a.length);i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<a.length;j++){
                if((i & 1 << j) > 0 ){
                    list.add(a[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

}
