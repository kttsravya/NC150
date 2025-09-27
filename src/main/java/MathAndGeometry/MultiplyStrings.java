package MathAndGeometry;

import java.util.Arrays;

public class MultiplyStrings {
    public static void main(String[] args){
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String res = multiplyStrings.multiply("111", "222");
        System.out.println(res);

    }

    public String multiply(String num1, String num2) {
        if( num1.isBlank()|| num2.isBlank() || num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        String number1 = new StringBuilder(num1).reverse().toString();
        String number2 = new StringBuilder(num2).reverse().toString();

        for(int i = 0; i < number1.length(); i ++){
            for(int j = 0; j < number2.length(); j ++){
                res[i+j] = res[i+j] + Character.getNumericValue(number1.charAt(i)) * Character.getNumericValue(number2.charAt(j));
                res[i + j + 1] = res[i+j+1]+ res[i + j] / 10;
                res[i + j] = res[i + j] % 10;
            }
            System.out.println(Arrays.toString(res));
        }
        StringBuilder result = new StringBuilder();
        int i = res.length - 1;
        while(i >= 0 && res[i] == 0){
            i --;
        }
        while(i >= 0){
            result.append(res[i--]);
        }
        return result.toString();
    }

}
