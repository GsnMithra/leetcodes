/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    
    let c = 0;
    
    s = s.trim();
    
    for(let i = s.length - 1; i >= 0; i--) {
        if(s[i - 1] < 0) {
            c++;
            break;
        }
        if(s[i].charCodeAt(0) == 32) break;
        c++;
    }
    
    return c;
};