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

    private static void buildGraphWithColor(int[][] prerequisites, Map<Integer,Integer> degree, Map<Integer, List<Integer>> graph) {
        int tasks = prerequisites.length;
        for(int i = 0; i < tasks; i++) {
            degree.put(i,WHITE);
            graph.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int source = pre[0];
            int dest = pre[1];
            List<Integer> list = graph.get(source);
            list.add(dest);
            graph.put(source, list);
        }
    }

    final static int WHITE = 0;
    final static int BLUE = 1;
    private static List<Integer> findPath(int tasks, int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();
        buildGraphWithColor(pre,inDegree, map);
        findPathHelper(map,inDegree,0,1, new ArrayList<>());
        return null;
    }

    private static void findPathHelper(Map<Integer, List<Integer>> map, Map<Integer,Integer> inDegree, int source, int target, List<Integer> path) {
        path.add(source);
        if(source == target) {
            // found path
            System.out.println(path);
            return;
        }

        if(inDegree.get(source) ==  BLUE) {

        } else {
            inDegree.put(source,BLUE);
            List<Integer> children = map.get(source);
            for(int child : children) {
                findPathHelper(map,inDegree,child,target,path);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> result = Utils.findPath(5,
                new int[][] { new int[] { 0, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 }, new int[] { 4, 2 }, new int[] { 2, 1 } });
        System.out.println(result);

//        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
//                new int[] { 2, 1 }, new int[] { 3, 1 } });
//        System.out.println(result);
//
//        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
//                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
//        System.out.println(result);
    }
}
