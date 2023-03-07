# 바나나나빠나나

import sys
sys.setrecursionlimit(100100)
input = sys.stdin.readline

dfa = [
    {'B': 1},   #0
    {'B': 1, 'A': 2},   #1
    {'N': 3},   #2
    {'A': 4},   #3
    {'N': 5},   #4
    {'A': 6},   #5
    {'N': 5, 'B': 1}    #6
]

get = input().strip()
memoization = [[0x3f3f3f3f for _ in range(len(dfa))] for _ in range(len(get))]

def dp(idx, state):
    if idx == len(get):
        return 0 if state == 6 else 0x3f3f3f3f
    if memoization[idx][state] != 0x3f3f3f3f:
        return memoization[idx][state]
    
    for f,v in dfa[state].items():
        if get[idx] == f:
            memoization[idx][state] = min(
                memoization[idx][state],
                dp(idx+1,v)
            )
        else:
            memoization[idx][state] = min(
                memoization[idx][state],
                dp(idx+1, v) + 1
            )
    return memoization[idx][state]
        
print(dp(0,0))
