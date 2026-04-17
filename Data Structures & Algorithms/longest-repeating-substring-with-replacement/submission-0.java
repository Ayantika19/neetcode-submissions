class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0, left = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(i)));
            while((i - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
