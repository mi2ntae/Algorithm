# 곱셈 : divide and conquer

import sys
sys.setrecursionlimit(100000000)
input = sys.stdin.readline

A,B,C = map(int, input().split())

def multiply(n):
    if n == 1:
        return A%C
    
    if n%2 == 1:
        val = multiply(n-1)
        return ((A%C)*(val%C))%C
    else:
        val = multiply(n//2)
        return ((val%C)*(val%C))%C
    
print(multiply(B))