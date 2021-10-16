# 히스토그램에서 가장 큰 직사각형

import sys
input = sys.stdin.readline
sys.setrecursionlimit(200001)

def divideConquer(i,j,histo):
    if i == j:
        return histo[i]
    mid = (i+j)//2
    minv = min(histo[mid],histo[mid+1])
    tmp = minv*2
    ml = mid
    mr = mid+1
    width = 2
    while True:
        if (histo[ml] == 0 or ml == i) and (histo[mr] == 0 or mr == j):
            break
        
        if histo[ml] == 0 or ml == i:
            if histo[mr+1] < minv:
                minv = histo[mr+1]
            mr += 1
        elif histo[mr] == 0 or mr == j:
            if histo[ml-1] < minv:
                minv = histo[ml-1]
            ml -= 1
        else:
            if histo[ml-1] > histo[mr+1]:
                if histo[ml-1] < minv:
                    minv = histo[ml-1]
                ml -= 1
            else:
                if histo[mr+1] < minv:
                    minv = histo[mr+1]
                mr += 1
        width += 1
        tmp = max(tmp, minv*width)
    return max(divideConquer(i,mid,histo),divideConquer(mid+1,j,histo),tmp)
    
    
        
while True:
    a = list(map(int, input().strip().split()))
    N = a[0]
    if N == 0:
        break
    histo = a[1:]
    print(divideConquer(0,N-1,histo))

    
    