class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), 0, nums, target);
        return result;
    }
    private void dfs(int i, List<Integer> current, int total, int[] nums, int target) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            current.add(nums[j]);
            dfs(j, current, total + nums[j], nums, target);
            current.remove(current.size() - 1);
        }
    }
}
