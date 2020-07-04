package sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Sandesh Mendan on 04/07/20
 * @project algorithms-and-datastructures
 */
public class BucketSort {
    public static void main(String[] args){
        int[] arr = { 10, 5, 30, 15, 50, 6 };
        bucketSort(arr);
        printArray(arr);
    }

    private static void bucketSort(int[] arr) {
        //find num of buckets and initialize it
        int numOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        ArrayList[] buckets = new ArrayList[numOfBuckets];

        //initializing empty buckets
        for(int i =0;i<buckets.length;i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        //find max value in array
        int maxValue = Integer.MIN_VALUE;
        for(int value: arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        //fill the elems into different bucket based on allocation formula (can be different also)
        for(int value : arr){
            int bucketNumber = (int) Math.ceil((float) (value * numOfBuckets) / maxValue);
            buckets[bucketNumber-1].add(value);
        }

        //sort individual bucket
        for(ArrayList bucket : buckets){
            Collections.sort(bucket);
        }

        //merge all buckets into single array
        int index=0;
        for(ArrayList<Integer> bucket: buckets) {
            for(int value: bucket) {
                arr[index] = value;
                index++;
            }
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
