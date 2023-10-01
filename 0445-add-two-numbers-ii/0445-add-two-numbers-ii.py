# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers (self, la: Optional[ListNode], lb: Optional[ListNode]) -> Optional[ListNode]:
        stackA, stackB = list (), list ()
        
        currA, currB = la, lb
        while currA or currB:
            if currA:
                stackA.append (currA.val)
                currA = currA.next
            if currB:
                stackB.append (currB.val)
                currB = currB.next

        def valueList (stack):
            value = 0
            while len (stack) != 0:
                value += stack.pop (0)
                value *= 10
            return value // 10 if value != 0 else 0
        
        def appendList (head, tail, value):
            if not head and head == tail:
                head = tail = ListNode (value)
            else:
                tail.next = ListNode (value)
                tail = tail.next
            return head, tail
            
        valueA, valueB = valueList (stackA), valueList (stackB)
        resultValue = str (valueA + valueB)
        
        head, tail = (None, None)
        while len (resultValue) != 0:
            head, tail = appendList (head, tail, int (resultValue[0]))
            resultValue = resultValue[1:]
        
        return head