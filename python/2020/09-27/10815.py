# 숫자 카드  divide and conquer

# import sys
# sys.setrecursionlimit(1000000000)

# N = int(input())
# cards = list(map(int, input().split()))
# cards.sort()
# M = int(input())
# nums = list(map(int, input().split()))

# result = ""

# def isRight(num, begin, end, i):
#     if num < cards[begin] or num > cards[end]:
#         return False
    
#     if num == cards[begin] or num == cards[end] or num == cards[i]:
#         return True
    
#     if end - begin == 1:
#         return False
    
#     if cards[begin] < num and num < cards[i]:
#         if isRight(num, begin, i, (begin+i)//2):
#             return True
#         else:
#             return False
#     elif cards[i] < num and num < cards[end]:
#         if isRight(num, i, end, (i+end)//2):
#             return True
#         else:
#             return False
    
# for num in nums:
#     begin = 0
#     end = len(cards)-1
#     i = len(cards)//2
#     if isRight(num, begin, end, i):
#         result += "1 "
#     else:
#         result += "0 "

# print(result)

# 이분탐색 풀이 binary search

import sys
sys.setrecursionlimit(1000000000)

N = int(input())
cards = list(map(int, input().split()))
cards.sort()
cards.append(10000001)
M = int(input())
nums = list(map(int, input().split()))

def isIn(begin, end, val):
    return cards[begin] <= val and val <= cards[end]

def isExist(val):
    bot, top = 0, len(cards)-1

    while bot + 1 < top:
        mid = (bot + top) // 2
        if isIn(bot, mid, val):
            top = mid
        else:
            bot = mid
    
    return cards[bot] == val

ans = []
for val in nums:
    if isExist(val):
        ans.append("1")
    else:
        ans.append("0")

print(" ".join(ans))


