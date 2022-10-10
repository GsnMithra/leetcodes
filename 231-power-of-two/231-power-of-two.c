
int bitK(int n, int k)
{
    if (n & (1 << (k - 1)))
        return 1;
    else
        return 0;
}


bool isPowerOfTwo(int n){
    
    int highBit = log2(n) + 1;
    int count = 0;
    
    for(int i = 1; i <= highBit; i++) {
        if(bitK(n, i)) count++;
    } 
    
    return count == 1 ? true : false;
}