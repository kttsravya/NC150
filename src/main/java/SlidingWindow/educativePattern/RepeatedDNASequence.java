package SlidingWindow.educativePattern;

import java.util.*;
//leetcode article
public class RepeatedDNASequence {
    public static void main(String[] args){

    }

    public static List<String> findRepeatedSequencesWithRabinKarp(String dna, int k) {
        int n = dna.length();
        if (n <= k) {
            return new ArrayList();
        }

        //rolling hash parameters: base a (since contains only 4 different characters in dna sequence)
        int a = 4, aL = (int) Math.pow(a, k);
        // convert string to array of integers
        Map<Character, Integer> toInt = new HashMap<>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
        };
        int[] nums = new int[n];
        for(int i = 0; i < n; i ++){
            nums[i] = toInt.get(dna.charAt(i));
        }

        int h = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        for(int start = 0; start < n -k +1; start ++){
            // compute has of the current sequency in O(1) time
            if(start != 0){
                h = h * a - nums[start - 1]*aL + nums[start + k - 1];
            }
            // compute hash of the first sequence in O(L) time
            else for(int i = 0; i < k; i ++){
                h = h*a + nums[i];
            }

            // update output and hashSet of seen sequence
            if(seen.contains(h)){
                output.add(dna.substring(start, start+k));
            }

            seen.add(h);
        }
        return new ArrayList<String>(output);
    }

    public static Set<String> findRepeatedSequences(String dna, int k) {
        int left = 0;
        Set<String> hashSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        for(int right = 0; right < dna.length(); right ++){
            if(right - left > k - 1){
                left ++;
            }
            if(right < k - 1){
                continue;
            }
            String subString = dna.substring(left, right+1);
            System.out.println("substring of length k is" + subString);
            if(hashSet.contains(subString)){
                resultSet.add(subString);
            }else{
                hashSet.add(subString);
            }
        }
        return resultSet;
    }
}
