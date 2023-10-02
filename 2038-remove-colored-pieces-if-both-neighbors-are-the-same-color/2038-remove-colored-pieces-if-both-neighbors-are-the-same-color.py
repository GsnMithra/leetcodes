class Solution:
    def winnerOfGame (self, colors: str) -> bool:
        
        colorFreq = {
            'A': 0,
            'B': 0
        }
        
        for i in range (1, len (colors)):
            if colors[i - 1:i + 2] == 'AAA':
                colorFreq['A'] += 1
            elif colors[i - 1:i + 2] == 'BBB':
                colorFreq['B'] += 1
           
        return True if colorFreq['A'] > colorFreq['B'] else False
            