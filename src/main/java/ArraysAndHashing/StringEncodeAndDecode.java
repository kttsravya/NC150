package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {
    public static void main(String[] args) {
        StringEncodeAndDecode stringEncodeAndDecode = new StringEncodeAndDecode();
        List<String> encoded = new ArrayList<>();
        encoded.add("neet");
        encoded.add("code");
        encoded.add("loves");
        String encode = stringEncodeAndDecode.encode(encoded);
        System.out.println("encoded string is " + encode);
        List<String> decoded = stringEncodeAndDecode.decode(encode);
        System.out.println(decoded.toString());
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0) {
            int delimiterIndex = sb.indexOf("#");
            String lengthInString = sb.substring(0, delimiterIndex);
            System.out.println("length in string is " + lengthInString);
            sb.delete(0, lengthInString.length() + 1);
            System.out.println("sb after substring metadata delete " + sb);
            decodedStrings.add(sb.substring(0, (int) Integer.valueOf(lengthInString)));
            sb.delete(0, (int) Integer.valueOf(lengthInString));
            System.out.println("sb after substring metadata delete " + sb);
        }
        return decodedStrings;
    }
}
