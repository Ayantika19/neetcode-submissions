class Solution {
    public boolean hasDuplicate(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                count++;
            if(count >= 1)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}