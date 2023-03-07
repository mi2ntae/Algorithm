# PPAP



# import sys
# input = sys.stdin.readline

# p = input().strip()

# ans = True
# tmp1 = 0
# for i in range(len(p)):
#     if p[i] == "A":
#         if i == len(p)-1:
#             ans = False
#             break
#         if tmp1 < 2:
#             ans = False
#             break
#         if p[i+1] != "P":
#             ans = False
#             break
#         else:
#             tmp1 -= 2
#     else:
#         tmp1 += 1

# print("PPAP" if tmp1 == 1 and ans else "NP")