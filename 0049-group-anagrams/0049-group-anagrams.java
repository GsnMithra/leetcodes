class Solution {
    public String getKey (String s) {
        char [] string = s.toCharArray ();
        Arrays.sort (string);
        return String.valueOf (string);
    }
    
    public List <List <String>> groupAnagrams (String [] strs) {
        Map <String, List <String>> anagramMap = new HashMap <>();
        for (String s : strs) {
            String key = getKey (s);
            anagramMap.putIfAbsent (key, new ArrayList <>());
            anagramMap.get (key).add (s);
        }
        
        List <List <String>> result = new ArrayList <>();
        anagramMap
            .entrySet ()
            .stream ()
            .forEach (e -> result.add (e.getValue ()));
        return result;
    }
}