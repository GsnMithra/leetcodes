/**
 * @param {string} s1
 * @param {string} s2
 * @return {string[]}
 */
var uncommonFromSentences = function(sa, sb) {
    let wordmap = new Map();
    
    let strx = sa.split(' ');
    let stry = sb.split(' ');
    
    for(let i = 0; i < strx.length; i++) {
        let nums = wordmap.get(strx[i]);
        if(wordmap.has(strx[i])) wordmap.set(strx[i], nums + 1);
        else wordmap.set(strx[i], 1);
    }
    
    for(let i = 0; i < stry.length; i++) {
        let nums = wordmap.get(stry[i]);
        if(wordmap.has(stry[i])) wordmap.set(stry[i], nums + 1);
        else wordmap.set(stry[i], 1);
    }
    
    let final = [];
    
    let i = 0;
    for (const [key, value] of wordmap) {
        if(value == 1) {
            final[i] = key;
            i++;
        }
    }
    
    return final;

};