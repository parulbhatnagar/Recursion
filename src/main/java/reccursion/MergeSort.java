package reccursion;

public class MergeSort {
    public static void main(String[] args) {

        int[] input = {4,1,3,2,0,-1,7,10,9,20};

        mergeSort(input, 0, input.length-1);


        System.out.println(input.toString());

    }

    public static void mergeSort(int [] inputArray, int startIndex, int endIndex){
        if (startIndex < endIndex){
            int mid = (startIndex + endIndex)/2;
            //broken into two  equal parts
            mergeSort(inputArray, startIndex, mid);
            mergeSort(inputArray, mid+1, endIndex);

            merge(inputArray, startIndex, mid, endIndex);
        }
    }

    public static void merge(int[] inputArray, int startIndex, int midIndex, int endIndex){
        // traverse from left to mid and
        int [] tempArray = new int[endIndex - startIndex + 1];

        // traverse from start to mid and compare the number against mid + 1 to  to end and populate the value n tempArray
        int i=startIndex, j= midIndex+1, k = 0;
        while (i <= midIndex && j <=endIndex){
            if (inputArray[i] < inputArray[j]){
                tempArray[k] = inputArray[i];
                k++;
                i++;
            } else {
                tempArray[k] = inputArray[j];
                k++;
                j++;
            }
        }
        while (i <=midIndex){
            tempArray[k] = inputArray[i];
            k++;
            i++;
        }
        while (j <=endIndex){
            tempArray[k] = inputArray[j];
            k++;
            j++;
        }
        // replace values in input array with the tempArray
        for (int x = startIndex; x<=endIndex; x++){
            inputArray[x] = tempArray[x-startIndex];
        }
    }
}
