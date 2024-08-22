package sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort (int arr[], int low, int high){
        // base condition

        if (low >= high){
            return;
        }

        int pivotIndex = getPivot(arr, low, high);;
        quickSort(arr, low, pivotIndex-1);
        quickSort(arr,pivotIndex+1,high);

    }

    private static int getPivot(int[] arr, int low, int high) {
        if (arr.length==1){
            return 0;
        }
        int pivotIndex = low;
        int left = low+1, right=high;

        while (left <=right){
            while (arr[pivotIndex]>arr[left]){
                left++;
                if (left>=high){
                    break;
                }
            }
            while (arr[pivotIndex] < arr[right]){
                right--;
                if(right<=low){
                    break;
                }
            }

            if (left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        if (pivotIndex<left-1){
            int temp = arr[left-1];
            arr[left-1] = arr[pivotIndex];
            arr[pivotIndex] = temp;
            pivotIndex = left-1;
        }
        return pivotIndex;
    }

    public static void main(String[] args) {
        int[] input = {1,6,9,1,2,8,5};
        quickSort(input, 0, input.length-1);

        System.out.println(Arrays.toString(input));
    }
}
