
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintPath {
    public static void main(String[] args) {
        int[][] edges = { { 0, 1 },
                { 0, 2 },
                { 0, 3 },
                { 2, 0 },
                { 2, 1 },
                { 1, 3 } };
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        path(2, 3, adj, paths, path, set);
        for (List<Integer> p : paths) {
            for (Integer val : p) {
                System.out.print(val + " -> ");
            }
            System.out.println();
        }
    }

    public static void path(int src, int dest, List<List<Integer>> adj, List<List<Integer>> paths, List<Integer> path,
            Set<Integer> visited) {
        visited.add(src);
        path.add(src);
        if (src == dest) {
            paths.add(new ArrayList<>(path));
        }
        for (Integer ver : adj.get(src)) {
            if (!visited.contains(ver)) {
                path(ver, dest, adj, paths, path, visited);
            }
        }
        if (!path.isEmpty()) {
            path.remove(path.size() - 1);
        }
        visited.remove(src);
    }
}
