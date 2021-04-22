package interview.twilio;

import java.util.*;
public class PushPull {

    public void printTracker(){
        for(Map.Entry<Integer, String> entry : tracker.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("-----------------");
    }
    public static void main(String[] args) {


        PushPull solution = new PushPull();
        solution.push("a"); // 0
        solution.printTracker();
        solution.push("b"); // 1
        solution.printTracker();
        solution.push("c"); // 2
        solution.printTracker();
        System.out.println("Below pulling... ");
        System.out.println(solution.pull(3));
        solution.printTracker();
        System.out.println(solution.pull(0));
        solution.printTracker();
        System.out.println(solution.pull(1));
        solution.printTracker();
        //System.out.println(solution.tracker.firstKey() + " " + solution.tracker.lastKey() +" "+ solution.tracker.size());
        System.out.println(solution.pull(0));
        solution.printTracker();
        System.out.println(solution.pull(0));
        solution.printTracker();

        solution.push("d");
        solution.printTracker();
        solution.push("e");
        solution.printTracker();
        solution.push("f");
        solution.printTracker();
        solution.push("g");
        solution.printTracker();
    }

    static int counter = 0;
    int capacity = 3;
    TreeMap<Integer, String> tracker = new TreeMap<>();

    //logN
    public void push(String payload){

        if(tracker.size() == capacity){ // .firstEntry()
            tracker.remove(tracker.firstKey());
        }
        tracker.put(counter, payload);
        counter++;
    }

    //logN
    public String pull(int num){
        if(tracker.isEmpty())
            return null;
        String result = null;
        if(num > tracker.lastKey()){
            return null;
        }else{
            if(tracker.containsKey(num)){
                result = tracker.get(num);
                tracker.remove(num);
                return result;
            }else{
                return pull(++num);
            }
        }
    }
}