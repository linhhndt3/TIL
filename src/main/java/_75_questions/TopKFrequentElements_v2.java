package _75_questions;

import java.util.*;

public class TopKFrequentElements_v2 {
    public static void main(String[] args) {
        new TopKFrequentElements_v2().topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        // enhance runtime - done by declare rs as an int[], not List<Integer>
        Map<Integer,Integer> map = new HashMap<>(); //TODO replace by primitive array
        List<List<Integer>> topFrequents = new ArrayList<>();
        int[] rs = new int[k];
        for(int i=0; i<=nums.length;i++){
            topFrequents.add(new LinkedList<>());
        }
        for(int i=0; i<nums.length; i++) {
            int frequent = map.getOrDefault(nums[i],0);
            map.put(nums[i],frequent+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int frequent = entry.getValue();
            List<Integer> listOfNumberWithTheSameFrequent = topFrequents.get(frequent);
            listOfNumberWithTheSameFrequent.add(value);
        }
        int count=k-1;
        for(int i=nums.length;i>=0;i--) {
            List<Integer> list = topFrequents.get(i);
            if(!list.isEmpty()) {
                for(Integer number: list) {
                    rs[count]=number;
                    if(count==0) {
                        return rs;
                    }
                    count--;
                }
            }
        }

        return rs;
    }

}