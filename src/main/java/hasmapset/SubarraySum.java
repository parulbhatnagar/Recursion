package hasmapset;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    // Subarray sum equals to K
    // e.g. arr={1,2,3}
    // K=3
    // Ans = 2 (1,2)(3)

    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int k = -10;

        //List<Integer> prefixArray = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);  // for null
        int sum=0;
        int count = 0;
        // prefix array
        for(int i:arr){
            sum += i;
            if (map.containsKey(sum-k)){
                count += map.get(sum-k) ;
            }
            if (map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else {
                map.put(sum,1);
            }
        }
        System.out.println("prefix Array is :" + map);
        System.out.println("answer = " + count);

        // sum(i,j) = prefix(j)-prefix(i-1)
        //  k = -10 = sum(i,j) = prefix(j)-prefix(i-1)
        // prefix(i-1) = prefix(j)-k

    }
}
