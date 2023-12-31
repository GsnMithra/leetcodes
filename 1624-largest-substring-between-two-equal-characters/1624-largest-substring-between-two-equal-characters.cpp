class Solution {
public:
    int maxLengthBetweenEqualCharacters (string s) {
        unordered_map <char, pair <int, int>> map;
        
        for (int i = 0; i < s.length (); i += 1) {
            if (map.find (s[i]) != map.end ()) 
                map[s[i]].second = i;
            else
                map[s[i]] = { i, -1 };
        }
        
        int maxString = INT_MIN;
        for (const auto& entry : map) {
            if (entry.second.second != -1) 
                maxString = max (maxString, entry.second.second - entry.second.first - 1);
        }
        
        return maxString == INT_MIN ? -1 : maxString;
    }
};