package interview.zalando;

public class Highest2Digit {
    public static void main(String[] args){
        System.out.println(max2Digit("50552"));
    }
    private static int max2Digit(String s) {
        int max2Digit = 0;
        for(int i = 0; i < s.length()-1; i++){
            int firstDigit = s.charAt(i) - '0';
            int secondDigit = s.charAt(i) - '0';
            int curr2Digit = firstDigit * 10 + secondDigit;
            max2Digit = Math.max(max2Digit, curr2Digit);
        }
        return max2Digit;
    }
}
