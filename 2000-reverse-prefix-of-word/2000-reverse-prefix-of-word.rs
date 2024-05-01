use std::collections::VecDeque;

impl Solution {
    pub fn reverse_prefix (word: String, ch: char) -> String {
        let mut stack = VecDeque::new ();
        
        let mut last: i32 = -1;
        for i in 0..word.len () {
            let c = word.chars ().nth (i).unwrap ();
            stack.push_back (c);
            if c == ch {
                last = (i as i32) + 1;
                break;
            }
        }
        
        if last == -1 {
            return word;
        }
        
        let mut result = String::new ();
        while !stack.is_empty () {
            let c = stack.pop_back ().unwrap ();
            result.push_str (&c.to_string ());
        }
        
        for i in (last as usize)..word.len () {
            let c = word.chars ().nth (i).unwrap ();
            result.push_str (&c.to_string ());
        }
        
        result
    }
}