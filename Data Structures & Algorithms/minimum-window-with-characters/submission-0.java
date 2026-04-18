class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) 
            return "";
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0, need = tMap.size();
        int[] result = {-1, -1};
        int resultLength = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(tMap.containsKey(c) && window.get(c).equals(tMap.get(c))) {
                have++;
            }
            while(have == need) {
                if((right - left + 1) < resultLength) {
                    resultLength = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(tMap.containsKey(leftChar) && window.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        return resultLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
