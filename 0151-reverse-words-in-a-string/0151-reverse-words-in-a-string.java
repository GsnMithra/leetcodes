class Solution {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" +");
        Collections.reverse(Arrays.asList(strings));
        
        return String.join(" ", strings);
    }
}