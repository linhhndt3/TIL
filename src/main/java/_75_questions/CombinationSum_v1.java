package _75_questions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_v1 {
    // TODO review
    // TODO note: combination sum(2 things 1st: dfs=backtracking, 2nd: avoid duplicate)
    public static void main(String[] args) {
        new CombinationSum_v1().combinationSum(new int[]{8,7,4,3},11);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSumHelper(candidates,target,0,path,rs);
        return rs;
    }

    public void combinationSumHelper(int[] candidates,int target, int startIndex, List<Integer> path, List<List<Integer>> rs) {
        for(int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            if(candidates[i] > target) {
            } else if(target == candidates[i]) {
                List<Integer> tempRs =new ArrayList<>(path);
                rs.add(tempRs);
            } else {
                combinationSumHelper(candidates, target - candidates[i], i, path, rs);
            }

            path.remove(path.size() - 1);
        }
    }
}