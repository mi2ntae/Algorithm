# 수 정렬하기 2  merge sort
# [u, v) : range() u를 포함하고 v를 포함하지 않는 것
import sys
sys.setrecursionlimit(10000000)
input = sys.stdin.readline

N = int(input())

nums = [int(input()) for _ in range(N)]

def mergeSort(arr, begin, end):
    if end-begin == 1:
        return
    
    mid = (begin+end)//2

    mergeSort(arr, begin, mid)
    mergeSort(arr, mid, end)

    tmp = [None] * (end - begin)
    b,m = begin,mid
    i = 0
    while b < mid or m < end:
        if b == mid:
            tmp[i] = arr[m]
            i += 1
            m += 1
        elif m == end:
            tmp[i] = arr[b]
            i += 1
            b += 1
        else:
            if arr[b] > arr[m]:
                tmp[i] = arr[m]
                i += 1
                m += 1
            else:
                tmp[i] = arr[b]
                i += 1
                b += 1
    for a, k in enumerate(tmp):
        arr[begin+a] = k

mergeSort(nums, 0, len(nums))
print("\n".join(map(str, nums)))





# def ms(arr, begin, end):
#     if end - begin == 1:
#         return

#     mid = (begin + end) // 2
#     ms(arr, begin, mid)
#     ms(arr, mid, end)

#     m = []

#     u, v = begin, mid
#     while u < mid or v < end:
#         if v == end:
#             m = [arr[u]]
#             u += 1
#         elif u == mid:
#             m = [arr[v]]
#             v += 1
#         else:
#             if arr[u] < arr[v]:
#                 m += [arr[u]]
#                 u += 1
#             else:
#                 m += [arr[v]]
#                 v += 1
#     for i, v in enumerate(m):
#         arr[begin+i] = v

# tar = [4,7,3,2,56,7,6,23]
# ms(tar, 3, len(tar))
# print(tal)