# 듣보잡 : hash

u = 2 ** 7 - 1
v = 2 ** 24 - 1

n,m = map(int, input().split())
table = [None] * v
ans = []

def hs(s):
    ret = 0
    for i in s:
        ret  = (ret * u + ord(i)) % v

    return ret

for _ in range(n):
    s = input().strip()
    inhs = hs(s)

    if not table[inhs]:
        table[inhs] = []

    table[inhs].append(s)

for _ in range(m):
    s = input().strip()
    inhs = hs(s)

    if table[inhs] and s in table[inhs]:
        ans.append(s)

ans.sort()
print(len(ans))
print("\n".join(ans))




















# import sys
# input = sys.stdin.readline

# def hs(s):
#     u = 2 ** 7 - 1
#     v = 2 ** 24 - 1

#     ret = 0
#     for ch in s:
#         ret = (ret * u + ord(ch)) % v

#     return ret

# hash_table = [None] * (2**24-1)
# ans = []

# N, M = map(int, input().split())

# for _ in range(N):
#     s = input().strip()
#     key = hs(s)
    
#     if not hash_table[key]:
#         hash_table[key] = []

#     hash_table[key].append(s)

# for _ in range(M):
#     s = input().strip()
#     key = hs(s)
#     if hash_table[key] and s in hash_table[key]:
#         ans.append(s)
# ans.sort()
# print(len(ans))
# print("\n".join(ans))