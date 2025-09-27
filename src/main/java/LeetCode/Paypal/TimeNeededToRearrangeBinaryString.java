package LeetCode.Paypal;

public class TimeNeededToRearrangeBinaryString {
    public static void main(String[] args){
        TimeNeededToRearrangeBinaryString timeNeeded =
                new TimeNeededToRearrangeBinaryString();
        System.out.println(timeNeeded.secondsToRemoveOccurrences("0110101"));
    }

    public int secondsToRemoveOccurrences(String s){
        int seconds = 0;
        while(s.indexOf("01") >= 0){
            System.out.println(s);
            s = s.replace("01","10");
            seconds ++;
        }
        return seconds;
    }


}
