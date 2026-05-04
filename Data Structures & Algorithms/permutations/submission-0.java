class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    public void backtrack(List<Integer> permutations, int[] nums, boolean[] pick) {
        if (permutations.size() == nums.length) {
            result.add(new ArrayList<>(permutations));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                permutations.add(nums[i]);
                pick[i] = true;
                backtrack(permutations, nums, pick);
                permutations.remove(permutations.size() - 1);
                pick[i] = false;
            }
        }
    }
}
