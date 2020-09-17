package problems.greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author sandesh.mendan on 17/09/20
 * @project algorithms-and-datastructures
 */

//Problem: we are given N activities with their start and finish times. Select the maximum no.of activities that can be performed
//         by a single person, assuming that a person can work only single activity at a time.
//TimeComplexity: NlogN sort + N traverse = O(N log N)
//SpaceComplexity: assuming quick sort avg case: O(log N)

public class ActivitySelection {
    public static void main(String[] args){
        //Create an ArrayList to store all activities
        ArrayList<Activity> activityList = new ArrayList<Activity>();

        //Insert activities in Arraylist
        activityList.add(new Activity("A1", 0, 6));
        activityList.add(new Activity("A2", 3, 4));
        activityList.add(new Activity("A3", 1, 2));
        activityList.add(new Activity("A4", 5, 8));
        activityList.add(new Activity("A5", 5, 7));
        activityList.add(new Activity("A6", 8, 9));

        //Print user entered data
        System.out.println("User provided Schedule:");
        for (int i = 0; i < activityList.size() ; i++) {
            Activity activity = activityList.get(i);
            System.out.println(activity.toString());
        }

        //Perform calculation on activities
        activitySelection(activityList);
    }

    private static void activitySelection(ArrayList<Activity> activityList) {
        Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                return a1.getFinishTime() - a2.getFinishTime();
            }
        };

        activityList.sort(finishTimeComparator);

        Activity firstActivity = activityList.get(0);
        System.out.println("\n\nRecommended Schedule:\n"+ firstActivity);

        for(int i = 0; i < activityList.size(); i++){
            if(firstActivity.getFinishTime() < activityList.get(i).getStartTime()){
                System.out.println(activityList.get(i));
                firstActivity = activityList.get(i);
            }
        }
    }
}
class Activity{
    private String name;
    private int startTime;
    private int finishTime;

    public Activity(String name, int startTime, int finishTime) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "Activity :" + name + ", start time = " + startTime + ", finish time = " + finishTime;
    }
}