class Solution {
    public String frequencySort (String s) {
        Map <Character, Integer> freqs = new HashMap <>();
        for (char c : s.toCharArray ()) 
            freqs.put (c, freqs.getOrDefault (c, 0) + 1);
        
        List <Map.Entry <Character, Integer>> entryList = new ArrayList <>(freqs.entrySet ());
        Collections.sort (entryList, (a, b) -> b.getValue () - a.getValue ());
        
        String result = "";
        for (int i = 0; i < entryList.size (); i += 1) {
            int freq = entryList.get (i).getValue ();
            char character = entryList.get (i).getKey ();
            while (freq --> 0)
                result += character;
        }
        
        return result;
    }
}