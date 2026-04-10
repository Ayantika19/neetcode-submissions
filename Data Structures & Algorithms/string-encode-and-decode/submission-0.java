class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String word : strs) {
            builder.append(word.length()).append('#').append(word);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimiterPos = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiterPos));
            i = delimiterPos + 1;
            String word = str.substring(i, i + length);
            list.add(word);
            i += length;
        }
        return list;
    }
}
