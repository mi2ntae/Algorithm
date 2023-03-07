# 파일 합치기
import sys
input = sys.stdin.readline

T = int(input().strip())

for _ in range(T):
    K = int(input().strip())
    num = list(map(int, input().strip().split()))

    memoization = [[0 for _ in range(K)] for _ in range(K)]
    acc = [0]

    for i in num:
        acc.append(acc[-1]+i)

    for d in range(1,K):
        for i in range(K-d):
            j = d+i
            memoization[i][j] = 0x3f3f3f3f
            for k in range(i,j):
                memoization[i][j] = min(
                    memoization[i][j],
                    memoization[i][k]+memoization[k+1][j]+acc[j+1]-acc[i]
                    )

    print(memoization[0][K-1])