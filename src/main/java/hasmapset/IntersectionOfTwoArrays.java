package hasmapset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Integer arr1[] = {7,3,9};
        Integer arr2[] = {6,3,9,2,9,4};

        // Intersection of two should be 3,9

        Set<Integer> set1 = new HashSet<>();
        set1.addAll(Arrays.stream(arr1).toList());

        System.out.println("Set 1 : \n" + set1);

        Set<Integer> set2 = new HashSet<>();
        set2.addAll(Arrays.stream(arr2).toList());

        System.out.println("Set 2 : \n" + set2);

        var itr = set1.iterator();
        while(itr.hasNext()){
            Integer lookupNumber=itr.next();
            if(set2.contains(lookupNumber)){
                System.out.print(lookupNumber+",");
            }
        }


    }
}
