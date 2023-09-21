
// [1, 2] [3, 4]
// [1, 2, 3, 4]


class Solution {
    public double findMedianSortedArrays (int [] numx, int [] numy) {
        int [] merged = new int [numx.length + numy.length];
        int nx = 0, ny = 0, nm = 0;
        
        while (nx < numx.length && ny < numy.length) {
            if (numx[nx] <= numy[ny])
                merged[nm++] = numx[nx++];
            else
                merged[nm++] = numy[ny++];
        }
        
        while (nx < numx.length) 
            merged[nm++] = numx[nx++];
        while (ny < numy.length) 
            merged[nm++] = numy[ny++];
        
        int size = merged.length;
        System.out.println (Arrays.toString (merged));
        
        return (size % 2 == 0) ? (double) (merged[(size / 2) - 1] + merged[size / 2]) / 2 : merged[size / 2];
    }
}