# 교수님은 기다리지 않는다 disjoint set
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000000)

result = []        

def uFind(k):
        if tree[k] == k:
            return k
        o = tree[k]

        tree[k] = uFind(tree[k])
        weight[k] += weight[o] 
        return tree[k]

def uMerge(a,b,w):
        ar = uFind(a)
        br = uFind(b)
        if ar == br:
            return
        
        tree[br] = ar
        weight[br] = w + weight[a] - weight[b]

while True:
    N,M = map(int, input().split())

    if N == 0 or M == 0:
        for i in result:
            print(i)
        break
    
    tree = [i for i in range(0,N+1)]
    weight = [0 for _ in range(N+1)]

    for _ in range(M):
        inp = input().split()
        com = inp[0]
        a = int(inp[1])
        b = int(inp[2])
        
        if com == "!":
            w = int(inp[3])
            uMerge(a,b,w)
        elif com == "?":
            if uFind(a) == uFind(b):
                print(weight[b] - weight[a])
            else:
                print("UNKNOWN")