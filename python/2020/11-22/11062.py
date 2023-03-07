# 카드 게임

import sys
input  = sys.stdin.readline
sys.setrecursionlimit(10001)

def game(cards,a,b):
    if memoization[a][b]:
        return memoization[a][b]
    if a == b:
        return (0,0)
    
    second1, first1 = game(cards,a+1,b)
    first1 += cards[a]
    second2, first2 = game(cards,a,b-1)
    first2 += cards[b-1]

    if first2 < first1:
        memoization[a][b] = (first1,second1)
        return memoization[a][b]
    else:
        memoization[a][b] = (first2,second2)
        return memoization[a][b]


T = int(input().strip())

for _ in range(T):
    N = int(input().strip())
    card = list(map(int, input().strip().split()))
    memoization = [[None for _ in range(N+1)] for _ in range(N+1)]
    print(game(card,0,N)[0])
    
    