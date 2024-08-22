package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergSort {

    public static void mergeSort(int [] arr, int left,int right){
        int mid = (right+left)/2;
       // System.out.println("left = " + left + "right = " + right +" mid  =" + mid);

        // base condition is if single array return
        if (left >=right) {
            return ;
        }

        mergeSort(arr, left, mid);
        mergeSort(arr,mid+1,right);
        merge(arr, left, mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int leftCurr = left, rightCurr = mid+1;

        List<Integer> list = new ArrayList<>();
        System.out.println("in MERGE");
        System.out.println("left = " + left + "right = " + right + "mid = " + mid);
        while (leftCurr<=mid && rightCurr<=right){
            if (arr[leftCurr] < arr[rightCurr]){
                // push lef in arr and left ++
                list.add(arr[leftCurr]);
                leftCurr++;
            }
            else {
                list.add(arr[rightCurr]);
                rightCurr++;
            }
        }
        while (leftCurr<=mid){
            list.add(arr[leftCurr]);
            leftCurr++;
        }
        while (rightCurr<=right){
            list.add(arr[rightCurr]);
            rightCurr++;
        }
        for (int j = left; j <=right; j++) {
            arr[j] = list.get(j-left);
        }
    }


    public static void main(String[] args) {
        int [] inputArr = {1,6,9,1,2,8,5};
        mergeSort(inputArr, 0, inputArr.length-1);
        System.out.println(Arrays.toString(inputArr));
    }
}
