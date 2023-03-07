# 숨바꼭질
from collections import deque

N,K = map(int,input().split())
q = deque()
q.append(N)
isvisited = [False for _ in range(200001)]
isvisited[N] = True
count = 0
isfind = False

if N > K:
    print(N-K)
else:
    for l in range(1, abs(K-N)+1):
        if isfind:
            break
        else:
            tmpq = deque()
            while q:
                cur = q.popleft()
                d = [1,-1,cur]

                for i in range(3):
                    curd = cur + d[i]
                    if curd == K:
                        count = l
                        isfind = True
                        break
                    else:
                        if curd >= 0 and \
                            curd <= 200000 and \
                            not isvisited[curd]:
                            tmpq.append(curd)
                            isvisited[curd] = True
            while tmpq:
                a = tmpq.popleft()
                q.append(a)

    print(count)


# N,K = map(int, input().split())
# isvisited = [False for _ in range(100001)]
# count = []

# def find(n,c):
#     if n > 100000 or n < 0 or c > abs(K-N):
#         return
#     if n == K:
#         count.append(c)
#         return

#     isvisited[n] = True
    
#     if not isvisited[n+1]:
#         find(n+1,c+1)
#     if not isvisited[n-1]:
#         find(n-1,c+1)
#     if not isvisited[n*2]:
#         find(n*2,c+1)

# find(N,0)
# print(min(count))


# from collections import deque

# N,K = map(int,input().split())

# isget = False
# count = 0
# q = deque()
# q.append(N)
# l = 0
# c = -1
# p = 0
# k = 1
# while not isget:
#     n = q.popleft()
#     c += 1
#     d = [1,-1,n]
    
#     if c - l == 3**p:
#         k += 1
#         l = c
#         p += 1

#     for i in range(3):
#         nxt = n + d[i]
#         if nxt == K:
#             isget = True
#             count = k
#             break
#         else:
#             q.append(nxt)

# print(count)
