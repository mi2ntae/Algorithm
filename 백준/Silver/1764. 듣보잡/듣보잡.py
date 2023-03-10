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