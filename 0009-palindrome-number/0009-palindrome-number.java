class Solution {
    public boolean isPalindrome(int x) {
        return (x == reverse(x))? true : false;
    }
    
    public int reverse(int n) {
        int reverse = 0;
        
        while(n > 0) {
            reverse = reverse * 10 + (n % 10);
            n /= 10;
        }
        
        return reverse;
    }
}