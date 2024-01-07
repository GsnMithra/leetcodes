class Solution {
public:
    bool oneLetterDiff (string a, string b) {
        int change = 0;
        for (int i = 0; i < a.size (); i += 1)
            change += (a[i] != b[i]) ? 1 : 0;
        return change == 1;
    }
    
    int ladderLength (string beginWord, string endWord, vector <string>& wordList) {
        if (beginWord == endWord)
            return 0;
        
        unordered_map <string, vector <string>> adj;
        int N = wordList.size ();
        
        for (int i = 0; i < N; i += 1) {
            for (int j = i + 1; j < N; j += 1) {
                if (oneLetterDiff (wordList[i], wordList[j])) {
                    adj[wordList[i]].push_back (wordList[j]);
                    adj[wordList[j]].push_back (wordList[i]);
                }
            }
        }
        
        deque <pair <string, int>> q;
        unordered_set <string> seen;
        
        for (int i = 0; i < wordList.size (); i += 1) {
            if (oneLetterDiff (wordList[i], beginWord)) 
                q.push_back (make_pair (wordList[i], 1));
        }
        
        if (q.empty ())
            return 0;
        
        while (!q.empty ()) {
            pair <string, int> p = q.front ();
            q.pop_front ();
            
            if (p.first == endWord)
                return p.second + 1;
            
            for (string neigh : adj[p.first]) {
                if (seen.find (neigh) == seen.end ()) {
                    seen.insert (neigh);
                    q.push_back (make_pair (neigh, p.second + 1));
                }
            }
        }
        
        return 0;
    }
};

