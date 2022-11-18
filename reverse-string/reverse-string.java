class Solution {
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }
    
    public void helper (char[] str, int f, int l) {
        if (f >= l) { return; }
        
        char temp = str[f];
        str[f] = str[l];
        str[l] = temp;
        
        helper(str, f + 1, l - 1);
    }
}