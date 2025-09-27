package LeetCode.AirBnb;

import java.util.ArrayList;
import java.util.List;

public class TestJustification {

    public static void main(String[] args){

    }

    public List<String> fullJustify(String[] words, int maxWidth){
        List<String> ans = new ArrayList<>();
        int i = 0;

        while(i < words.length){
            List<String> currentLine = getWords(i, words, maxWidth);
            i = i + currentLine.size();
            ans.add(createLine(currentLine, i, words, maxWidth));
        }
        return ans;
    }

    private String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int baseLength = -1;
        for(String word : line){
            baseLength = baseLength + word.length() + 1;
        }
        int extraSpaces = maxWidth - baseLength;
        if(line.size() == 1 || i == words.length){
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }
        int wordCount = line.size() - 1;
        int spacesPerWord = extraSpaces/wordCount;
        int needsExtraSpace = extraSpaces % wordCount;

        for(int j = 0; j < needsExtraSpace; j ++){
            line.set(j, line.get(j) + " ");
        }
        for(int j = 0; j < wordCount; j ++){
            line.set(j, line.get(j) + " ".repeat(spacesPerWord));
        }
        return String.join(" ", line);
    }

    private List<String> getWords(int i, String[] words, int maxWidth) {
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        while(i < words.length && currentLength + words[i].length() <= maxWidth){
            currentLine.add(words[i]);
            currentLength = currentLength + words[i].length();
            currentLength = currentLength + 1;
            i++;
        }
        return currentLine;
    }
}
