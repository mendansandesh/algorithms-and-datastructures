package interview.sharechat;
// Problem: https://leetcode.com/problems/single-element-in-a-sorted-array/
// Time: O(log N) //since we used binary search
// Space: O(1)
public class FindElement {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int[] arr = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8};
        //int[] arr = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8};
        //int[] arr = {1};
        findSingleElem(arr, 0, arr.length - 1);
    }

    /*
         This problem follows below property
         (LHS) "RequiredElement" (RHS)
         (all elems 1st occurrence is EVEN and second is ODD position) "RequiredElement" (all elems 1st occurrence is ODD and second is EVEN position)
     */
    private static void findSingleElem(int[] arr, int low, int high) {
        if(low > high) // base condition
            return;

        if(low == high){ // base condition
            System.out.println("Element repeated once in the sorted array is: " + arr[low]);
            return;
        }

        int mid = (low + high) / 2;

        if(mid % 2 == 0){
            //here we can check any direction; back or front
            // need to be careful while making recursive calls; give proper index based on property defined above
            if(arr[mid - 1] == arr[mid]) //indicates elem is in the LHS; so search left
                findSingleElem(arr, low, mid - 2);
            else //search right
                findSingleElem(arr, mid, high);
        }else {
            //here we can check any direction; back or front
            if(arr[mid] == arr[mid + 1]) //indicates elem is in the LHS; so search left
                findSingleElem(arr, low, mid - 1);
            else //search right
                findSingleElem(arr, mid + 1, high);
        }
    }
}
