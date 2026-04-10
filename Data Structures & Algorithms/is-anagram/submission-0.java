class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            int freqS = sMap.getOrDefault(s.charAt(i), 0);
            if(freqS != 0)
                sMap.put(s.charAt(i), freqS + 1);
            else
                sMap.put(s.charAt(i), 1);
            int freqT = tMap.getOrDefault(t.charAt(i), 0);
            if(freqT != 0)
                tMap.put(t.charAt(i), freqT + 1);
            else
                tMap.put(t.charAt(i), 1);
        }
        return sMap.equals(tMap);
    }
}
