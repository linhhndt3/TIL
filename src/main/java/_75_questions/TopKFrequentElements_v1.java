package _75_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements_v1 {
    public static void main(String[] args) {
        new TopKFrequentElements_v1().topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(); //TODO replace by primitive array
        Queue<ValueAndFrequent> heap = new PriorityQueue<>((a,b)-> b.frequent - a.frequent);
        for(int i=0; i<nums.length; i++) {
            int frequent = map.getOrDefault(nums[i],0);
            map.put(nums[i],frequent+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int frequest = entry.getValue();
            heap.add(new ValueAndFrequent(value,frequest));
        }
        int[] rs = new int[k];
        int count=0;
        while(count<k) {
            rs[count]=heap.poll().value;
            count++;
        }
        return rs;
    }



    class ValueAndFrequent {
        public int value;
        public int frequent;

        public ValueAndFrequent(int value, int frequent) {
            this.value=value;
            this.frequent=frequent;
        }
    }
}