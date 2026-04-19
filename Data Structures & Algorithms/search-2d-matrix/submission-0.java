class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, row = matrix.length, column = matrix[0].length, right = column - 1;
        while(left < row && right >= 0) {
            if(matrix[left][right] > target) {
                right--;
            } else if (matrix[left][right] < target) {
                left++;
            } else {
                return true;
            }
        } 
        return false;
    }
}
