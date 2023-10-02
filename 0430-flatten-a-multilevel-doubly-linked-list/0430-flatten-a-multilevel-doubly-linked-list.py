"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def __init__ (self):
        self.front = None
        self.rear = None

    def flattenUtil (self, head):
            if not head:
                return
            
            self.appendNode (head.val)
            if head.child:
                self.flattenUtil (head.child)
            self.flattenUtil (head.next)
    
    def appendNode (self, val):
            if not self.front and self.front == self.rear:
                self.front = self.rear = Node (val, None, None, None)
            else:
                newNode = Node (val, self.rear, None, None)
                self.rear.next = newNode
                self.rear = newNode
    
    def flatten (self, head: 'Optional[Node]') -> 'Optional[Node]':
        self.flattenUtil (head)
        return self.front