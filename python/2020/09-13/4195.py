# 친구 네트워크
import sys
input = sys.stdin.readline

T = int(input())



for _ in range(T):
    F = int(input())

    tree = [[0]]
    a,b = input().split()

    for i in tree:
      #  if i == a or i == b:

        if i != a:
            tree.append(a)
        if i != b:
            tree.append(b)
    
    print(tree)
    
    
