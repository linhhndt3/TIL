package subset;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<List<Integer>> rs = new ArrayList<>();
        subsets.add(new ArrayList<>());
        findSubsets(nums,subsets, rs);
        return rs;
    }

    public static void findSubsets(int[] nums, List<List<Integer>> subsets, List<List<Integer>> rs) {
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> tempSubsets = new ArrayList<>();
            for(List<Integer> subset : subsets) {
                tempSubsets.add(new ArrayList<>(subset));
                List<Integer> cloned = new ArrayList<>(subset);
                cloned.add(nums[i]);
                tempSubsets.add(cloned);
            }
            subsets = tempSubsets;
        }
        for(List<Integer> subset : subsets) {
            rs.add(subset);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
