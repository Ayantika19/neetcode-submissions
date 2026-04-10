class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suffixArray = new int[nums.length];
        int[] prefixArray = new int[nums.length];
        int[] output = new int[nums.length];
        suffixArray[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            suffixArray[i] = suffixArray[i - 1] * nums[i - 1];
        }
        prefixArray[nums.length - 1] = 1; 
        for(int i = nums.length - 2; i >= 0; i--) {
            prefixArray[i] = nums[i + 1] * prefixArray[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = suffixArray[i] * prefixArray[i];
        }
        return output;
    }
}  
