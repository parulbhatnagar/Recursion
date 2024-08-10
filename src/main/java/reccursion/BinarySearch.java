package reccursion;

public class BinarySearch {

    // Assumption here is that list of array that we will get will be a sorted one
    // you go to midle index and compare the number if it is same less or more and
    // then take a call if we want to search further left or right
    // e.g. -1, 0, 1, 2, 3, 4, 6, 9, 10, 20
    // we are looking for input number in this sorted array

    public static void main(String[] args) {
        int inputArray[] = {-1,0,1,2,3,4,6,10,20};

        int indexOfSearchNumber = -1;

        indexOfSearchNumber = binarySearch(inputArray, 0,inputArray.length-1, 1);

        System.out.println("index of searched number is = " + indexOfSearchNumber);
    }

    public static int binarySearch(int[] inputArray, int startIndex, int endIndex, int number){
        // base condition
        if (startIndex == endIndex && inputArray[startIndex] !=number){
            return -1;
        }
        int centerIndex = (endIndex - startIndex)/2;

        if (number == inputArray[startIndex+centerIndex]){
            return startIndex+centerIndex;
        } else if (number>inputArray[centerIndex]) {
            // move to right hand side array
            return binarySearch(inputArray, startIndex+centerIndex,endIndex,number);
        }else {
            //move left
            return binarySearch(inputArray,startIndex,endIndex-centerIndex,number);
        }
    }
}
