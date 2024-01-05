class Solution {
public:
    vector <int> findDiagonalOrder (vector <vector <int>>& mat) {
        // 0 1 2
        // 1 2 3
        // 2 3 4
        map <int, vector <int>> map;
        for (int i = 0; i < mat.size (); i += 1) {
            for (int j = 0; j < mat[i].size (); j += 1) {
                map[i + j].push_back (mat[i][j]);
            }
        }
        
        vector <int> result;
        bool up = true;
        for (const auto& entry : map) {
            int size = entry.second.size () - 1;
            if (up) {
                while (size >= 0) {
                    result.push_back (entry.second[size]);
                    size -= 1;
                }
            } else {
                for (int i = 0; i <= size; i += 1)
                    result.push_back (entry.second[i]);
            }
            
            up = !up;
        }
        
        return result;
    }
};