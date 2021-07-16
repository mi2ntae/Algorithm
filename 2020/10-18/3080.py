# 아름다운 이름
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

class Node():
    def __init__(self, lazy):
        self.isEnd = False
        self.child = {}
        self.lazy = lazy

childsize = ord('Z') - ord('A') + 1
trie = Node(None)
fac = [1]
v = 1000000007

def insert(trie, string):
    cur = trie
    for i in range(len(string)):
        s = string[i]
        if cur.lazy:
            cur.child[cur.lazy[0]] = Node(cur.lazy[1:])
            cur.isEnd = False
            cur.child[cur.lazy[0]].isEnd = True
            cur.lazy = None
        if s not in cur.child:
            cur.child[s] = Node(string[i+1:])
            cur = cur.child[s]
            break
        cur = cur.child[s]
    cur.isEnd = True

    return

def DFS(trie):
    child_count = 1 if trie.isEnd else 0
    ret = 1

    for child in trie.child.values():
        child_count += 1
        ret = (ret * DFS(child)) % v
    
    ret  = (ret * fac[child_count]) % v
    return ret
    
for i in range(1, childsize+1):
    fac.append((i*fac[-1])%v)

N = int(input())

for _ in range(N):
    name = input().strip()
    insert(trie, name)

print(DFS(trie))