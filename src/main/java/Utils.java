import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> rs = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();
        buildGraph(graph,inDegree, map);
        findPathHelper(map,rs,new ArrayList<>(),0);
        return  rs;
    }
    public void findPathHelper(Map<Integer, List<Integer>> graph, List<List<Integer>> sortedOrder, List<Integer> path, int start) {
        path.add(start);
        if(start == graph.size() - 1) {
            sortedOrder.add(new ArrayList<>(path));
        }
        for(Integer child : graph.get(start)) {
            findPathHelper(graph,sortedOrder,path,child);
        }
        path.remove(path.size() - 1);
    }

    private void buildGraph(int tasks, int[][] prerequisites, Map<Integer,Integer> degree, Map<Integer, List<Integer>> graph) {

        for(int i = 0; i < tasks; i++) {
            degree.put(i,0);
            graph.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int source = pre[0];
            int dest = pre[1];
            List<Integer> list = graph.getOrDefault(source, new ArrayList<Integer>());
            list.add(dest);
            graph.put(source, list);
            degree.put(dest, degree.get(dest) + 1);
        }
    }

    private static void buildGraph(int[][] prerequisites, Map<Integer,Integer> degree, Map<Integer, List<Integer>> graph) {
        int tasks = prerequisites.length;
        for(int i = 0; i < tasks; i++) {
            degree.put(i,0);
            graph.put(i, new ArrayList<>());
        }

        int node = 0;
        for(int[] pre : prerequisites) {
            List<Integer> list = graph.get(node);
            for(int dest : pre) {
                list.add(dest);
                degree.put(dest, degree.get(dest) + 1);
            }
            graph.put(node, list);
            node++;
        }
    }
}
