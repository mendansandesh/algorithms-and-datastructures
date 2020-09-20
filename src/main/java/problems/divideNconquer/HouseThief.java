package problems.divideNconquer;

/**
 * @author sandesh.mendan on 18/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
// Level: Easy
// TimeComplexity:
// SpaceComplexity:
public class HouseThief {
    public static void main(String[] args) {
        int[] houseNetWorth = new int[] {2,7,9,3,1}; //6, 7, 1, 30, 8, 2, 4
        System.out.println(maxMoney(houseNetWorth));
    }

    public static int maxMoney(int[] houseNetWorth) {
        return findMaxRecursive(houseNetWorth, 0);
    }

    private static int findMaxRecursive(int[] houseNetWorth, int index) {
        if(index >= houseNetWorth.length-1)
            return 0;
        int withCurrHouse = houseNetWorth[index] + findMaxRecursive(houseNetWorth, index+2);
        int withoutCurrHouse =  findMaxRecursive(houseNetWorth, index+1);
        return Math.max(withCurrHouse, withoutCurrHouse);
    }
}
