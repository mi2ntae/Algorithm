# Contact

import sys
input = sys.stdin.readline

automata = [
    [5,1],
    [2,7],
    [3,7],
    [3,4],
    [5,8],
    [7,6],
    [5,1],
    [7,7],
    [9,8],
    [3,6]
]

T = int(input())

for _ in range(T):
    pattern = input().strip()
    end = 0
    for i in pattern:
        i = int(i)
        end = automata[end][i]
    if end in [4,6,8]:
        print("YES")
    else:
        print("NO")