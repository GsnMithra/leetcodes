class Solution {
    public boolean isSubsequence (String s, String t) {
        Queue <String> queue = new LinkedList <>();
        for (int i = 0; i < s.length (); i += 1) 
            queue.offer (s.substring (i, i + 1));
        
        for (int i = 0; i < t.length (); i += 1) {
            if (queue.isEmpty ())
                return true;
            if (queue.peek ().equals (t.substring (i, i + 1)))
                queue.poll ();
        }
        
        return queue.isEmpty ();
    }
}