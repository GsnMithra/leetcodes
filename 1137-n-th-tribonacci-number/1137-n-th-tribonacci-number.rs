use std::collections::HashMap;

impl Solution {
    fn tribonacciUtil (n: i32, dp: &mut HashMap <i32, i32>) -> i32 {
        if let Some (&v) = dp.get (&n) {
            return v;
        }
        if n == 0 || n == 1 {
            n
        } else if n == 2 {
            1
        } else {
            let first = Self::tribonacciUtil (n - 1, dp);
            let second = Self::tribonacciUtil (n - 2, dp);
            let third = Self::tribonacciUtil (n - 3, dp);
            dp.insert (n, first + second + third);
            *dp.get (&n).unwrap ()
        }
    }
    
    pub fn tribonacci (n: i32) -> i32 {
        let mut dp = HashMap::new ();
        Self::tribonacciUtil (n, &mut dp)
    }
}