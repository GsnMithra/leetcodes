class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap <Character, Integer> smap = new HashMap<>();
        HashMap <Character, Integer> tmap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            Integer i = smap.get (c);
            if (smap.containsKey (c)) smap.put (c, i + 1);
            else smap.put (c, 1);
        }
        
        for (char c : t.toCharArray()) {
            Integer i = tmap.get (c);
            if (tmap.containsKey (c)) tmap.put (c, i + 1);
            else tmap.put (c, 1);
        }
        
        return smap.equals(tmap);
    }
}