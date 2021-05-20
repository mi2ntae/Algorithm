# 재귀 암호만들기

import sys
sys.setrecursionlimit(10000000)

a = input().split()
L = int(a[0])
C = int(a[1])

alp = sorted(input().split())

def count(alp):
    ja = 0
    mo = 0
    for i in alp:
        if i in ["a","e","i","o","u"]:
            mo += 1
        else:
            ja += 1
    
    return ja, mo


def ca(al, pick, cur):
    if al < pick:
        return
    if pick == 0:
        ja, mo = count(cur)
        if ja >= 2 and mo >= 1:
            print(cur)
        return
    ca(al-1, pick-1, cur+alp[-al])
    ca(al-1, pick, cur)

ca(C,L,"")