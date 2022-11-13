class Solution {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" +");
        String reverse = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            reverse += strings[i];
            if (i != 0) reverse += " ";
        }
        
        return reverse;
    }
}