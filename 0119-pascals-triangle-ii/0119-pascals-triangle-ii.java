// [1, 1, 1, 1, 1]
// [1, 2, 3, 4, 5]
// [1, 3, 6, 10, 15]
// [1, 4, 10, 20, 35]
// [1, 5, 15, 35, 70]


class Solution {
    public List <Integer> getRow (int rowIndex) {
        int [] grid [] = new int [rowIndex + 2][rowIndex + 2];
        for (int i = 0; i < grid.length; i += 1) {
            if (i > rowIndex)
                break;
            if (i == 0)
                Arrays.fill (grid[i], 1);
            else {
                for (int j = 0; j < grid.length; j += 1) {
                    if (j == 0)
                        grid[i][j] = 1;
                    else
                        grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }
        
        int i = rowIndex, j = 0;
        List <Integer> result = new ArrayList <>();
        while (i >= 0) 
            result.add (grid[i--][j++]);
        
        return result;
    }
}