package hasmapset;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Given an integer array of size n, find all the elements that appear more than n/3 times
    // e.g. nums[] = {1,3,2,5,1,3,1,5,1} Answer will be 1
    // e.g. nums[] = {1,2} Answer will be 1,2

    public static void main(String[] args) {
        //int nums[] = {1,3,2,5,1,3,1,5,1};
        int nums[] = {1,3};

        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i:nums){
            numMap.put(i,numMap.get(i)==null?1:numMap.get(i)+1);
        }
        int eligibleCount = nums.length/3;
        String output="";

        for(Map.Entry entry:numMap.entrySet()){
            if ((int)entry.getValue() >= eligibleCount){
                output += entry.getKey().toString()+",";
            }
        }
        System.out.println(numMap);
        System.out.println(output);


    }
}
