package _recall_75_questions;

import java.util.*;

public class _210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> path = new LinkedList<>();
        Map<Integer,List<Integer>> map = buildMapPrerequisites(numCourses,prerequisites);
        Set<Integer> possibleFinishedSet = new HashSet<>();
        for(int courseId = 0; courseId < numCourses; courseId++) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> whetherValid = new HashSet<>();
            findOrderHelper(courseId,path,possibleFinishedSet,visited,map,whetherValid);
            if(whetherValid.size() > 0) {
                return new int[]{};
            }
        }
        return path.stream().mapToInt(i->i).toArray();
    }
    private void findOrderHelper(int courseId, List<Integer> path, Set<Integer> possibleFinishedSet, Set<Integer> visited, Map<Integer, List<Integer>> mapPrerequisites,Set<Integer> whetherValid ) {
        if(whetherValid.size() > 0) {
            return;
        }
        if(possibleFinishedSet.contains(courseId)) {
            return;
        }
        if(visited.contains(courseId)) {
            whetherValid.add(-1);
            return;
        }
        visited.add(courseId);
        if(mapPrerequisites.get(courseId) == null) {
            possibleFinishedSet.add(courseId);
            path.add(courseId);
            return;
        }
        for(Integer neighbor : mapPrerequisites.get(courseId)) {
            findOrderHelper(neighbor,path,possibleFinishedSet,visited,mapPrerequisites,whetherValid);
            if(whetherValid.size() > 0) {
                return;
            }
        }
        possibleFinishedSet.add(courseId);
        path.add(courseId);
        return;
    }

    private Map<Integer, List<Integer>> buildMapPrerequisites(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int destCourse = prerequisite[0];
            int sourceCourse = prerequisite[1];
            List<Integer> prerequisiteList = map.getOrDefault(destCourse,new LinkedList<>());
            prerequisiteList.add(sourceCourse);
            map.put(destCourse,prerequisiteList);
        }
        return map;
    }
}