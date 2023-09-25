class Solution {
    public char findTheDifference (String s, String t) {
        if (s.length () == 0)
            return t.charAt (0);

        char [] sc = s.toCharArray ();
        Arrays.sort (sc);
        char [] tc = t.toCharArray ();
        Arrays.sort (tc);

        for (int i = 0; i < sc.length; i += 1) {

            if (sc[i] != tc[i])
                return tc[i];
        }

        return tc[tc.length - 1];
    }
}