package heaps;

import java.util.Arrays;

public class Heapify {

    public static void convertToHeap(int[] arr, int size, int largest){
        int parent = largest;
        int child1 = 2 * largest  + 1;
        int child2 = 2 * largest  + 2;

        if (child1 >= size && child2>=size ){
            return;
        }

        if (child1 < size && arr[parent] < arr[child1]){
            // swap
            swap(arr,parent,child1);
        }
        if (child1 < size && arr[parent] < arr[child2]){
            // swap
            swap(arr,parent,child2);
        }
        convertToHeap(arr, size, child1);
        convertToHeap(arr, size, child2);
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }

    public static void hepSort(int[] arr, int size){

        for (int i=size-1; i>=0;i--) {
            swap(arr,0, i);
            convertToHeap(arr, i-1, 0);
        }
    }

    public static void main(String[] args) {
        int [] input = {3,6,9,1,5,2,8};

        System.out.println(Arrays.toString(input));
        convertToHeap(input, input.length, 0);

        hepSort(input, input.length);

        System.out.println(Arrays.toString(input));

    }
}
