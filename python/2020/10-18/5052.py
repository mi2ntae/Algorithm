# 전화번호 목록

import sys
input = sys.stdin.readline

def insert_trie(trie, s):
    offset = ord('0')
    is_valid = True
    create_count = 0
    cur = trie
    for c in s:
        if not cur[1][ord(c) - offset]:
            cur[1][ord(c) - offset] = [False, [None] * 10]
            create_count += 1
        cur = cur[1][ord(c) - offset]
        is_valid = is_valid and not cur[0]
    cur[0] = True
    return is_valid and 0 < create_count

T = int(input())
for _ in range(T):
    trie = [False, [None] * 10]
    N = int(input())
    is_valid = True
    for _ in range(N):
        dial = input().strip()
        is_valid = is_valid and insert_trie(trie, dial)
    print("YES" if is_valid else "NO")