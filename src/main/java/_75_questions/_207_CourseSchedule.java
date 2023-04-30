package _75_questions;

import java.util.*;

public class _207_CourseSchedule {

    public static void main(String[] args) {
        System.out.println();
//        new _207_CourseSchedule().canFinish(2,new int[][] {{1,0}, {0,1}});
//        new _207_CourseSchedule().canFinish(3,new int[][] {{1,0}, {2,0}, {0,2}});
        new _207_CourseSchedule().canFinish(5,new int[][] {{0,1}, {0,2}, {1,3},{1,4},{3,4}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = buildMap(numCourses,prerequisites);
        Set<Integer> set = new HashSet<>();
        for(int course = 0; course < numCourses; course++) {
            if(!dfs(map,course, set)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, Integer source, Set<Integer> set) {
        // TODO how to init map
        // TODO review logic dfs
        // TODO capture vocab
        if(map.get(source) == null) {
            return true;
        }
        if(set.contains(source)) {
            return false;
        }
        set.add(source);
        List<Integer> prerequisites = map.get(source);
        for(Integer prerequisite : prerequisites) {
                if(!dfs(map,prerequisite,set)) {
                    return false;
                }
        }
        set.remove(source);
        map.put(source,null);
        return true;
    }

    public Map<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int des = prerequisite[0];
            int pre = prerequisite[1];
            List<Integer> pres = map.getOrDefault(des, new ArrayList<>());
            pres.add(pre);
            map.put(des, pres);
        }
        return map;
    }
}