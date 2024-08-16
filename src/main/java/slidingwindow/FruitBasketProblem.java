package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitBasketProblem {

    public static int totalFruits(Integer[] arr) {
        // code here
        int left = 0, right =1, maxFruitCount = 0, totalNumberOfFruitTrees = arr.length;
        int basketOneType, basketTwoType = 0;
        int basketOneCount =0 , basketTwoCount = 0;

        basketOneType = arr[0];
        basketOneCount++;
        int prevFruitType = basketOneType;

        while (right < totalNumberOfFruitTrees){
            // first validation condition
            if (arr[right] == basketOneType) {
                basketOneCount++;
                right++;

            } else if (arr[right] == basketTwoType){
                basketTwoCount++;
                right++;
            } else {
                // new type of fruit detected, check current maxFruitCount
                maxFruitCount = maxFruitCount>basketOneCount+basketTwoCount?maxFruitCount:basketOneCount+basketTwoCount;
                //remove the fruits from basket which doesn't have current and previous basket fruit
                if (basketOneType != prevFruitType){
                    // clear the basket
                    basketOneCount =1;
                    basketOneType = arr[right];
                }else{
                    basketTwoCount = 1;
                    basketTwoType = arr[right];
                }
                prevFruitType = arr[right];
                left++;
                right++;

            }
            // if true we will expand
            // else we will shrink
        }
        return maxFruitCount>basketOneCount+basketTwoCount?maxFruitCount:basketOneCount+basketTwoCount;
    }

    public static void main(String[] args) {
        Integer arr[] = {85,12,69,8,34,53,72,60,29,48,32,66,19,27,6,27,44,44,60,80,22,73,65,8,62,81,41,20,76,12,6,65,45,1,90,84,74,32,90,44,27,79,91,21,36,82,70,8,83,59,39,20,70,15,5,28,29,54,51,34,51,1,71,56,15,29,68,8,68,51,7,72,70,6,9,39,21,2,22,18,36,79,10,84,29,8,42,22,1,42,62};
        System.out.println( "max len : = " + totalFruits(arr));
    }
}
