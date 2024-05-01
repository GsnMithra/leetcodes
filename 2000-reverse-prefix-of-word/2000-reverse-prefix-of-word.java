class Solution {
    public String reversePrefix (String word, char ch) {
        Stack <Character> stc = new Stack <>();
        
        int last = -1;
        for (int i = 0; i < word.length (); i += 1) {
            char c = word.charAt (i);
            stc.push (c);
            if (c == ch) {
                last = i + 1;
                break;
            }
        }
        
        if (last == -1)
            return word;
        
        String result = "";
        while (!stc.isEmpty ())
            result += stc.pop ();
        for (int i = last; i < word.length (); i += 1)
            result += word.charAt (i);
        return result;
    }
}