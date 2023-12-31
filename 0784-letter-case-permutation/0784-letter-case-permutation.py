class Solution:
    def letterUtil (self, s: str, i: int) -> None:
        if i == len (s):
            self.result.append (str (s))
            return
        
        if not (ord (s[i]) - 48 >= 0 and ord (s[i]) - 48 <= 9):
            self.letterUtil (s, i + 1)
            if s[i].islower ():
                s = s[:i] + s[i].upper () + s[i + 1:]
            else:
                s = s[:i] + s[i].lower () + s[i + 1:]
            self.letterUtil (s, i + 1)
        else:
            self.letterUtil (s, i + 1)
    
    def letterCasePermutation (self, s: str) -> List[str]:
        self.result = list ()
        self.letterUtil (s, 0)
        
        return self.result