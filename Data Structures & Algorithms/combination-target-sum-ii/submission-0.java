class Solution {
    private static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result.clear();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, candidates, target);
        return result;
    }
    private static void dfs(
        int idx, List<Integer> path, int current, int[] candidates, int target) {
        if (current == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (current + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            dfs(i + 1, path, current + candidates[i], candidates, target);
            path.remove(path.size() - 1);
        }
    }
}
