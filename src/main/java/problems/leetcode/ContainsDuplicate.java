package problems.leetcode;

import java.util.HashSet;

/**
 * Created by sandesh on 6/7/22
 */
public class ContainsDuplicate {
  public static void main(String[] args){
    int[] arr = {2,4,1};
    if(containsDuplicate(arr))
      System.out.println("yes");
    else
      System.out.println("no");
  }

  public static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> distinct = new HashSet<>();
    for(int num : nums) {
      if(distinct.contains(num)) {
        return true;
      }
      distinct.add(num);
    }
    return false;
  }

}
