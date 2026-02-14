
import java.util.*;

public class CycleInDAG {
    public static void main(String[] args) {
        int[] frm = { 0, 1, 0, 2 };
        int[] to = { 1, 2, 3, 3 };
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<frm.length;i++){
            adj.add(new ArrayList<>());
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i =0;i<frm.length;i++){
            adj.get(frm[i]).add(to[i]);
        }

        

        boolean[]  visited = new boolean[frm.length];
        boolean[]  stack = new boolean[frm.length];
        
       for(int i=0;i<frm.length;i++){
        if(!visited[i]){
            boolean b = isCycle(adj, i, visited, stack);
            if(b){
                System.out.println("Exist");
            }
        }
       }


    }

    public static boolean  isCycle(List<List<Integer>> adj,Integer src,boolean[] visited,boolean[] stck){

      
        if(stck[src]){
            return true;
        }

        if(visited[src]){
            return false;
        }

        visited[src] = true;
        stck[src] = true;
        
        for(Integer s : adj.get(src)){
            if(isCycle(adj, s, visited, stck)){
                return true;
            }
        }
        stck[src] = false;
        return false;
    }
}
