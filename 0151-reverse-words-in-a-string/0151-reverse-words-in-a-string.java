class Solution {
    public static String deleteCharacterAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);
    }  
    
    public String reverseWords(String s) {
        
        s = s.stripLeading();
        s = s.stripTrailing();
        
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 0; j < s.length() - 1; j ++) {
                if (s.charAt(j) == s.charAt(j + 1) && s.charAt(j) == ' ') {
                    s = deleteCharacterAt(s, j);
                }    
            }
        }
        
        String[] strings = s.split(" ");
        String reverse = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            reverse += strings[i];
            if (i != 0) reverse += " ";
        }
        
        return reverse;
    }
}