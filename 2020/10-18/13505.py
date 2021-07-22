# 두 수 XOR

n = int(input())
N = list(map(int, input().split()))

trie = [None] * 2
maxv = 0

def find(trie, num):
    cur = trie
    ret = 0
    for i in range(30):
        v = (num >> (29 - i)) & 1
        if not cur[v]:
            v = 1-v

        cur = cur[v]
        ret = (ret << 1) | v

    return ret

def insert(trie, num):
    cur = trie
    for i in range(30):
        v = (num >> (29 - i)) & 1
        if not cur[v]:
            cur[v] = [None] * 2
        cur = cur[v]
    
    return

insert(trie, N[0])

for i in N[1:]:
    maxv = max(find(trie, ~i) ^ i, maxv)
    insert(trie, i)

print(maxv)