package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort( int[] arr){
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length-j-1 ; i++) {
                if (arr[i] > arr[i+1]){
                    // swap
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] input = {3,6,9,1,2,8,5};

        bubbleSort(input);

        System.out.println( "sorted array : "+ Arrays.toString(input));
    }
}
