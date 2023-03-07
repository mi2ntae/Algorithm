# 시험 감독

N = int(input())
A = list(map(int, input().split()))
B,C = map(int, input().split())
superv = 0

for i in range(N):
    crowd = A[i]
    if crowd <= B:
        superv += 1
        continue
    
    crowd -= B
    superv += 1

    superv += crowd//C
    if crowd%C != 0:
        superv += 1

print(superv)