# 문자열 집합
import sys
input = sys.stdin.readline

N,M = map(int, input().split())

trie = [False, [None] * 26]

def inputTrie(trie, name):
    offset = ord('a')
    cur = trie

    for c in name:
        if not cur[1][ord(c) - offset]:
            cur[1][ord(c) - offset] = [False, [None] * 26]
        cur = cur[1][ord(c) - offset]
    cur[0] = True

def checkTrie(trie, name):
    isIn = True
    offset = ord('a')
    cur = trie

    for c in name:
        if not cur[1][ord(c) - offset]:
            isIn = False
            break
        cur = cur[1][ord(c) - offset]
    
    return isIn and cur[0]

for _ in range(N):
    name = input().strip()
    inputTrie(trie, name)
    
result = 0
for _ in range(M):
    name = input().strip()
    if checkTrie(trie, name):
        result += 1

print(result)