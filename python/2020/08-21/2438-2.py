# 별 피라미드 찍기

get = int(input())
a = "*"
b = " "
k = 1
j = get-1

for _ in range(1,get+1):
    print(b*j+k*a)
    k += 2
    j -= 1
