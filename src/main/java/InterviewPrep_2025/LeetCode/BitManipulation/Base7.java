package InterviewPrep_2025.LeetCode.BitManipulation;

public class Base7 {
    public static void main(String[] args){
        int num = -7;
        System.out.println(convertToBase7(num));
    }

    public static String convertToBase7(int num){
        boolean isNegative = num < 0 ;
        StringBuilder base7Number = new StringBuilder();
        num = Math.abs(num);
        while((num / 7 ) > 0){
            base7Number.insert(0,num % 7);
            num = num/7;
        }
        base7Number.insert(0, num % 7);
        base7Number = isNegative?base7Number.insert(0,"-"):base7Number;
        return base7Number.toString();
    }
}
