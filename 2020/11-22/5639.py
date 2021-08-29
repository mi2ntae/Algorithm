# 이진 검색 트리

class Node:
    def __init__(self, v):
        self.v = v
        self.l = None
        self.r = None

import sys

sys.setrecursionlimit(10000)
print = sys.stdout.write

node = []

for line in sys.stdin:
    a = line.strip()
    node.append(Node(int(a)))

def insert(cur,des):
    if cur.v < des.v:
        if des.l == None:
            des.l = cur
        else:
            insert(cur,des.l)
    else:
        if des.r == None:
            des.r = cur
        else:
            insert(cur,des.r)

def dfs(node):
    if node == None:
        return
    dfs(node.l)
    dfs(node.r)
    print(str(node.v)+"\n")

des = node[0]
for i in node[1:]:
    insert(i,des)
    
dfs(node[0])