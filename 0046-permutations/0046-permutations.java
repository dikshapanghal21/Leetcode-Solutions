import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, current, result);

        return result;
    }

    private void backtrack(
        int[] nums,
        boolean[] used,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // All numbers are used
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number
        for (int i = 0; i < nums.length; i++) {

            // Skip already used numbers
            if (used[i]) {
                continue;
            }

            // Choose
            current.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums, used, current, result);

            // Undo
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}