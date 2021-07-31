# 좋은 친구
import sys
input = sys.stdin.readline

N,K = map(int, input().split())

friend = []
lens = [0 for _ in range(21)]
good_count = 0

for _ in range(N):
    name = input().strip()
    friend.append(len(name))

for i in range(K):
    lens[friend[i]] += 1

for i in range(N):
    if i+K < N:
        lens[friend[i+K]] += 1
    cur = friend[i]
    lens[cur] -= 1
    good_count += lens[cur]

print(good_count)