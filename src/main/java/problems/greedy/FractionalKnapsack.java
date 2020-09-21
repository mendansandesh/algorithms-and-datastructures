package problems.greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author sandesh.mendan on 21/09/20
 * @project algorithms-and-datastructures
 */
// Problem: https://www.geeksforgeeks.org/fractional-knapsack-problem/
// Level: Easy
// TimeComplexity:
// SpaceComplexity:
public class FractionalKnapsack {
    public static void main(String[] args){
        //Create Array of Objects
        ArrayList<Knapsack>items = new ArrayList<>();
        int [] value = {60, 40, 100, 120};
        int [] weight = {10, 40, 20, 30};
        int capacity = 50;

        //Add the user input data in Knapsack
        for(int i = 0; i < value.length; i++)
            items.add(new Knapsack(i+1, value[i], weight[i]));

        //Send the data for further processing
        maxValueKnapsack(items, capacity);
    }

    private static void maxValueKnapsack(ArrayList<Knapsack> items, int capacity) {
        Comparator<Knapsack> ratioComparator = (k1, k2) -> {
            if(k2.getRatio() > k1.getRatio()) return 1;
            else return -1;
        };

        //sort items based on value/weight ratio
        items.sort(ratioComparator);

        int maxVal = 0;

        for(Knapsack knapsack : items){
            int currentWeight = knapsack.getWeight();
            int currentValue = knapsack.getValue();

            if(capacity - currentWeight >= 0){
                capacity -= currentWeight;
                maxVal += currentValue;
            }else {
                double fractionWeight = (double) capacity / (double) currentWeight;
                maxVal += currentValue * fractionWeight;
                //below statements just for understanding purpose
                //capacity -= (capacity - (currentWeight * fraction)); OR
                //capacity = 0; //as we are taking only the fractionWeight
                break;
            }
        }

        System.out.println("\nTotal value obtained: "+ maxVal);
    }
}

class Knapsack {
    private int itemNo;
    private int value;
    private int weight;
    private double ratio;

    public Knapsack(int itemNo, int value, int weight) {
        this.itemNo = itemNo;
        this.value = value;
        this.weight = weight;
        ratio = value * 1.0 / weight;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}