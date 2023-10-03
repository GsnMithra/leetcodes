class Solution {
    public boolean powerUtil (int power, int n, boolean pole) {
        if (power < -100 || power > 100)
            return false;
        if (Math.pow (3, power) == n)
            return true;
        
        return powerUtil (pole ? power + 1 : power - 1, n, pole);
    }
    
    public boolean isPowerOfThree (int n) {
        return powerUtil (0, n, false) || powerUtil (0, n, true);
    }
}