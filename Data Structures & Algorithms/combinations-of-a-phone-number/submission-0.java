class Solution {
    private List<String> result = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return result;
        backtrack(0, "", digits);
        return result;
    }
    private void backtrack(int i, String current, String digits) {
        if (current.length() == digits.length()) {
            result.add(current);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, current + c, digits);
        }
    }
}
