package tree.dfs;

import java.util.*;

public class AllTaskSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {
        // TODO: Encapsulate(recall) the ideas
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> degree = new HashMap<>();
        buildGraph(tasks,prerequisites,degree,graph);
        List<List<Integer>> orders = new ArrayList<>();
        List<Integer> sources = new LinkedList<>();
        for(int i = 0; i < tasks; i++) {
            if(degree.get(i) == 0) {
                sources.add(i);
            }
        }
        printOrdersHelper(tasks,graph,degree,orders, sources, new ArrayList<>());
    }

    public static void printOrdersHelper(int task,Map<Integer, List<Integer>> graph,Map<Integer,Integer> degree, List<List<Integer>> orders, List<Integer> sources, List<Integer> path) {
        if(path.size() == task) {
            orders.add(path);
        }
        for(Integer source : sources) {
            path.add(source);
            List<Integer> nextSource = cloneSource(sources);
            nextSource.remove(source);
            printOrdersHelper(task,graph,degree,orders,nextSource,path);
            List<Integer> nbs = graph.get(source);
            for(Integer nb : nbs) {
                List<Integer> nextChildSource = new ArrayList<>();
                degree.put(nb,degree.get(nb) - 1);
                if(degree.get(nb)==0) {
                    nextChildSource.add(nb);
                }
            }
            printOrdersHelper(task,graph,degree,orders,graph.get(source),path);
        }
    }

    private static List<Integer> cloneSource(List<Integer> sources) {
        List<Integer> clonedSource = new ArrayList<>(sources);
        return clonedSource;
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(4, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 0, 3 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }

    // makes a deep copy of the queue
    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }

    private static void buildGraph(int tasks, int[][] prerequisites, Map<Integer,Integer> degree, Map<Integer, List<Integer>> graph) {

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
}
