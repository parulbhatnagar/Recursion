package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort( int[] arr){
        int minIndex = 0;
        for (int j=0; j< arr.length; j++) {
            for (int i = j; i < arr.length; i++) {
                if (minIndex<j) minIndex = j;
                if (arr[i] <= arr[minIndex]) {
                    minIndex = i;
                }
            }
            System.out.println("j = " + j + " minIndex = " + minIndex);
            // swap a[j] with a[minIndex]
            if (j != minIndex) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[j];
                arr[j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] input = {3,6,9,1,2,8,5};

        selectionSort(input);

        System.out.println( "sorted array : "+ Arrays.toString(input));
    }
}
