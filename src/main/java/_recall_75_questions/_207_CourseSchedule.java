package _recall_75_questions;

import java.util.*;

public class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build map
        Map<Integer,List<Integer>> mapPrerequisites = buildMapPrerequisites(numCourses,prerequisites);
        Set<Integer> possibleFinishedSet = new HashSet<>();
        for(int numCourse = 0; numCourse < numCourses; numCourse++) {
            Set<Integer> visited = new HashSet<>();
            if(!canFinishHelper(numCourse,possibleFinishedSet,visited,mapPrerequisites)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinishHelper(int courseId, Set<Integer> possibleFinishedSet,Set<Integer> visited,Map<Integer,List<Integer>> mapPrerequisites ) {
        if(!mapPrerequisites.containsKey(courseId)) {
            return true;
        }
        if(possibleFinishedSet.contains(courseId)) {
            return true;
        }
        if(visited.contains(courseId)) {
            return false;
        }
        visited.add(courseId);
        for(Integer neighbor : mapPrerequisites.get(courseId)) {
            boolean isAbleToFinish = canFinishHelper(neighbor,possibleFinishedSet,visited,mapPrerequisites);
            if(!isAbleToFinish) {
                return false;
            }
        }
        possibleFinishedSet.add(courseId);
        return true;
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