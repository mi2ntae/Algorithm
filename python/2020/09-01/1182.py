# 재귀 부분수열의 합
import sys
sys.setrecursionlimit(1000000000)

n,s = input().split()
N = int(n)
S = int(s)

nums = input().split()
pick = 0

def suy(pickC, sum, idx, ispick):
    global pick
    if idx >= N:
        return

    if sum == S and pickC >= 1 and ispick == True:
        pick += 1
    suy(pickC, sum, idx+1, False)
    suy(pickC+1, sum+int(nums[idx]), idx+1, True)
    
suy(0,0,-1,False)
print(pick)