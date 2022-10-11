package subset;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> tempRs = new ArrayList<>();
            for(int j = 0; j < result.size(); j++) {
                List<Integer> previousPermutation = result.get(j);
                List<List<Integer>> temp = generatePermutation(previousPermutation,nums,i);
                for(List<Integer> list : temp) {
                    tempRs.add(list);
                }
            }
            result = tempRs;
        }
        return result;
    }

    private static List<List<Integer>> generatePermutation(List<Integer> previousPermutation, int[] nums, int indexOfNums) {
        List<List<Integer>> permutations = new ArrayList<>();
        for(int i = 0; i <= previousPermutation.size(); i++) {
            List<Integer> clonedPreviousPermutation = new ArrayList<>(previousPermutation);
            clonedPreviousPermutation.add(i,nums[indexOfNums]);
            permutations.add(clonedPreviousPermutation);
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        List<List<Integer>> permutations = generatePermutation(list,new int[] { 1, 3, 5 },2);
//        System.out.println();
    }
}
