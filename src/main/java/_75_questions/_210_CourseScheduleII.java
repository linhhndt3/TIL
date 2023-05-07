package _75_questions;

import java.util.*;

public class _210_CourseScheduleII {

    public static void main(String[] args) {
        int[] rs = new _210_CourseScheduleII().findOrder(4, new int[][]{{0,1},{0,2},{1,3}, {2,3}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] path = new int[numCourses];
        Map<Integer,List<Integer>> prerequisiteMap = buildMap(numCourses,prerequisites);
        Set<Integer> finishableCourse = new HashSet<>();
        Set<Integer> addedToPath = new HashSet<>();
        for(int numCourse = 0; numCourse < numCourses; numCourse++) {
            dfs(numCourse,path,prerequisiteMap,finishableCourse,addedToPath);
        }

        return path;
    }

    public void dfs(int numCourse, int[] path, Map<Integer,List<Integer>> prerequisiteMap,
                    Set<Integer> finishableCourse, Set<Integer> addedToPath) {

        if(addedToPath.size() >= prerequisiteMap.size()) {
            return;
        }
        if(finishableCourse.contains(numCourse)) {
            return;
        }
        path[addedToPath.size()] = numCourse;
        addedToPath.add(numCourse);
        List<Integer> prerequisites = prerequisiteMap.get(numCourse);
        if(prerequisites == null) {
            finishableCourse.add(numCourse);
            return;
        }
        for(Integer prerequisite: prerequisites) {
            dfs(prerequisite, path, prerequisiteMap,finishableCourse,addedToPath);
        }
        finishableCourse.add(numCourse);

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
        for(int course = 0; course < numCourses; course++) {
            map.putIfAbsent(course,null);
        }
        return map;
    }
}