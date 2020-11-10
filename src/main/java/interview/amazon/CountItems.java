package interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandesh.mendan on 09/11/20
 * @project algorithms-and-datastructures
 */
/*
Problem: https://leetcode.com/discuss/interview-question/861453/amazon-oa-2020-items-in-containers
s = "|**|*|*"
startInd = [1,1]
endInd = [5,6]
count '*' enclosed by '|' between each start and end index
above ex:
between [1,5] there are 2 *'s between 2 '|' at 1 and 4 ==> total 2 *'s
between [1,6] there are 2 *'s between 2 '|' at 1 and 4 AND 1 * between 2 '|' at 4 and 6 ==> total 3 *'s
FinalAnswer = [2,3]
 */
public class CountItems {
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> result = new ArrayList<>(startIndices.size());
        if(startIndices.size() != endIndices.size())
            return result;
        for(int i = 0; i < startIndices.size(); i++){
            String subString = s.substring(startIndices.get(i) - 1, endIndices.get(i));
            int compartmentItems = countStarBetween2Indices(startIndices.get(i) - 1, endIndices.get(i)-1, subString);
            result.add(compartmentItems);
        }
        return result;
    }

    public static int countStarBetween2Indices(int startIndex, int endIndex, String str){
        int firstPipeIndex = -1;
        int nextPipeIndex = -1;
        int fullCompartmentCount = 0;
        int subCompartmentCount = 0;
        for(int i = startIndex; i <= endIndex; i++){
            firstPipeIndex = (firstPipeIndex == -1) ? str.indexOf('|') : nextPipeIndex;
            nextPipeIndex = firstPipeIndex + str.substring(firstPipeIndex + 1, endIndex+1).indexOf('|') + 1;
            if(firstPipeIndex == nextPipeIndex)
                break;
            else
                subCompartmentCount = countStarBetween2Pipes(firstPipeIndex, nextPipeIndex, str);
            fullCompartmentCount += subCompartmentCount;
            subCompartmentCount = 0;
            i = nextPipeIndex;
        }
        return fullCompartmentCount;
    }

    public static int countStarBetween2Pipes(int firstPipeIndex, int nextPipeIndex, String str){
        int starCount = 0;
        for(int i = firstPipeIndex; i <= nextPipeIndex && i < str.length(); i++){
            if(str.charAt(i) == '*')
                starCount++;
        }
        return starCount;
    }

    public static void main(String[] a){
        /*String s = "*|*|";
        List<Integer> startIndices = Arrays.asList(new Integer[]{1, 1});
        List<Integer> endIndices = Arrays.asList(new Integer[]{1, 3});*/
        String s = "|**|*|*";
        List<Integer> startIndices = Arrays.asList(new Integer[]{1, 1});
        List<Integer> endIndices = Arrays.asList(new Integer[]{5, 6});
        System.out.println(numberOfItems(s, startIndices, endIndices));
    }
}
