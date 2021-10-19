# 염색체

import sys
input = sys.stdin.readline

automata = [
    [2,1,1,1,1,1],
    [2,6,6,6,6,6],
    [2,6,6,6,6,3],
    [6,6,4,6,6,3],
    [5,5,4,5,5,5],
    [6,6,6,6,6,6],
    [6,6,6,6,6,6]
]

T = int(input().strip())

k = ord('A')

for _ in range(T):
    q = input().strip()
    end = 0
    for i in q:
        if ord(i)-k > 5:
            end = 0
            break
        end = automata[end][ord(i)-k]
        
    print("Infected!" if end in [4,5] else "Good")
