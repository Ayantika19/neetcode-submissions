class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, result = 0;
        while(left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            result = Math.max(result, area);
            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
