# 트리 복구

import sys
sys.setrecursionlimit(27)

class Node:
    def __init__(self,s,v):
        self.s = s
        self.v = v
        self.l = None
        self.r = None

def insert(tree, m, M, cur):
    if not tree:
        return tree

    if tree[0].v < m or M <= tree[0].v:
        return tree

    if cur.v < tree[0].v and tree[0].v < M:
        cur.r = tree[0]
        return insert(tree[1:], cur.v + 1, M, cur.r)

    if m <= tree[0].v and tree[0].v < cur.v:
        cur.l = tree[0]
        tree = insert(tree[1:], m, cur.v, cur.l)
        if tree and cur.v < tree[0].v and tree[0].v < M:
            cur.r = tree[0]
            tree = insert(tree[1:], cur.v, M, cur.r)
        return tree

def post_order(node, ans):
    if node == None:
        return ans
    
    ans = post_order(node.l,ans)
    ans = post_order(node.r,ans)
    ans += node.s
    return ans

for line in sys.stdin:
    pre_order, in_order = line.strip().split()
    tree = []
    for i in range(len(pre_order)):
        for k in range(len(in_order)):
            if pre_order[i] == in_order[k]:
                tree.append(Node(pre_order[i],k))
                break
    
    cur = tree[0]
    tree = insert(tree[1:], 0, 27, cur)

    ans = ""
    print(post_order(cur,ans))
