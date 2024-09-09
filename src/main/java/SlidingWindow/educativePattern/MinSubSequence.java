package SlidingWindow.educativePattern;
// educative explination
public class MinSubSequence {
    public static void main(String[] args){

    }

    public static String minWindow(String str1, String str2){
        int sizeStr1 = str1.length();
        int sizeStr2 = str2.length();
        int length = Integer.MAX_VALUE;
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0;
        int end = 0;
        String misSubSequence = "";
        while(indexS1 < sizeStr1){
            if(str1.charAt(indexS1) == str2.charAt(indexS2)){
                indexS2 ++;
                if(indexS2 == sizeStr2){
                    start = indexS1;
                    end = indexS1;
                    indexS2 = indexS2 - 1;
                    while(indexS2 >= 0){
                        if(str1.charAt(start) == str2.charAt(indexS2)){
                            indexS2 = indexS2 - 1;
                        }
                        start --;
                    }
                    start = start + 1;
                    if((end - start +  1) < length){
                        length = end - start +1;
                        misSubSequence = str1.substring(start, end+1);
                    }
                    indexS1 = start;
                    indexS2 = 0;
                }
            }
            indexS1 ++;
        }
        return misSubSequence;
    }

}
