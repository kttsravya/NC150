package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumWithDuplicates {
    public static void main(String[] args) {
        CombinationSumWithDuplicates dup = new CombinationSumWithDuplicates();
        int[] candidates = {9, 2, 2, 4, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = dup.combinationSum2(candidates, target);
        System.out.println(result.toString());

        result = dup.combinationSum2WithRecursionAndForLoop(candidates, target);
        System.out.println(result.toString());
    }


    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        Arrays.sort(candidates);
        int index = 0;
        combinationSum2Helper(index, candidates, target, sum, res);
        return res;
    }

    //int[] candidates = {9,2,2,4,6,1,5};
    private void combinationSum2Helper(int index, int[] candidates, int target, List<Integer> combination, List<List<Integer>> res) {
        if (target == 0) {
            System.out.println("current combination is " + combination);
            res.add(List.copyOf(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index >= candidates.length) {
            return;
        }

        combination.add(candidates[index]);
        combinationSum2Helper(index + 1, candidates, target - candidates[index], combination, res);

        int elementToBePopped = combination.get(combination.size() - 1);
        combination.remove(combination.size() - 1);
        while (index + 1 < candidates.length && elementToBePopped == candidates[index + 1]) {
            index = index + 1;
        }
        combinationSum2Helper(index + 1, candidates, target, combination, res);
    }

    public List<List<Integer>> combinationSum2WithRecursionAndForLoop(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackCombinationSum2WithRecursionAndForLoopHelper(sum, 0, target, candidates, res);
        return res;
    }

    private void backtrackCombinationSum2WithRecursionAndForLoopHelper(List<Integer> cur, int pos, int target, int[] candidates, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        int prev = -1;
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] == prev) {
                continue;
            }
            cur.add(candidates[i]);
            backtrackCombinationSum2WithRecursionAndForLoopHelper(cur, i + 1, target - candidates[i], candidates, res);
            cur.remove(cur.size() - 1);
            prev = candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), 0, target, candidates, res);
        return res;
    }

    private void backtrack(List<Integer> cur, int pos, int target, int[] candidates, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }

        int prev = -1;
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] == prev) {
                continue;
            }
            cur.add(candidates[i]);
            backtrack(cur, i + 1, target - candidates[i], candidates, res);
            cur.remove(cur.size() - 1);
            prev = candidates[i];
        }
    }


}
