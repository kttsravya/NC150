package Graph;

import java.util.*;

public class WordLadder {
    Map<String, List<String>> adjacencyMap = new HashMap<>();
    Queue<String> queue = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();

    public static void main(String[] args){
        WordLadder wordLadder = new WordLadder();
        int ladderLength = wordLadder.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(ladderLength);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        wordList.add(beginWord);
        preprocessWordList(wordList);
        queue.add(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                String popped = queue.poll();
                if(visited.contains(popped)){
                    continue;
                }
                if(popped.equals(endWord)){
                    return level +1;
                }
                for(int j = 0; j < popped.length(); j ++){
                    String leftSubString = popped.substring(0, j);
                    String rightSubString = popped.substring(j+1);
                    String pattern = leftSubString.concat("*").concat(rightSubString);
                    System.out.println(pattern);
                    queue.addAll(adjacencyMap.get(pattern));
                }
                visited.add(popped);
            }
            level++;
        }
        return 0;
    }

    private void preprocessWordList(List<String> wordList) {
        for(int i = 0; i < wordList.size(); i ++){
            String currentWord = wordList.get(i);
            for(int j = 0; j < currentWord.length(); j ++){
                String leftSubString = currentWord.substring(0, j);
                String rightSubString = currentWord.substring(j+1);
                String pattern = leftSubString.concat("*").concat(rightSubString);
                List<String> neighborList = adjacencyMap.getOrDefault(pattern, new ArrayList<>());
                neighborList.add(currentWord);
                adjacencyMap.put(pattern, neighborList);
            }
        }
    }
}
