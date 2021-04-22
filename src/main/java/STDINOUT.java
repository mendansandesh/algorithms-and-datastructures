import java.util.Arrays;
import java.util.Scanner;

public class STDINOUT {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        STDINOUT stdinout = new STDINOUT();
        stdinout.format1(scanner);
    }

    /**
     * 1 -- num of testCases
     * 4 -- array size
     * 4 2 5 1 -- array elems
     */
    public void format1(Scanner scanner){
        //System.out.println("Num of test cases: ");
        int testCases = scanner.nextInt();
        //System.out.println(testCases);
        for(int i = 1; i <= testCases; i++){
            //System.out.println("Num of array elems: ");
            int numberOfItemsInArray = scanner.nextInt();
            //System.out.println(numberOfItemsInArray);
            scanner.nextLine();
            //System.out.println("elems: ");
            String arrayElems = scanner.nextLine();
            //System.out.println(arrayElems);
            String[] arr = arrayElems.split(" ");
            int[] arrInts = new int[arr.length];
            for(int j = 0; j < arr.length; j++)
                arrInts[j] = Integer.parseInt(arr[j]);
            //System.out.println(Arrays.toString(arrInts));
            //todo: call func(arrInts) here
        }
    }

    /**
     * 1   -- num of testCases
     * 4   -- 2D array rows
     * 4 2 -- array elems
     * 1 3
     * 6 2
     * 9 6
     */
    public void format2(Scanner scanner){
        //System.out.println("Num of test cases: ");
        int testCases = scanner.nextInt();
        //System.out.println(testCases);
        for(int i = 1; i <= testCases; i++){
            //System.out.println("Num of array of array elems: ");
            int numberOfItemsInArrayofArray = scanner.nextInt();
            //System.out.println(numberOfItemsInArrayofArray);
            //todo: note: array size
            int[][] arrofArrInts = new int[numberOfItemsInArrayofArray][numberOfItemsInArrayofArray];
            scanner.nextLine();
            for(int j = 0; j < numberOfItemsInArrayofArray; j++){
                //System.out.println("elems: ");
                String eachRow = scanner.nextLine();
                String[] arr = eachRow.split(" ");
                for(int k = 0; k < arr.length; k++)
                    arrofArrInts[j][k] = Integer.parseInt(arr[k]);
                /*System.out.println("-----------------");
                if(j == 3)
                    for(int f = 0; f < arrofArrInts.length; f++)
                        System.out.println("-- " + Arrays.toString(arrofArrInts[f]));*/
            }

            //todo: call func(arrofArrInts) here
        }

    }
}
