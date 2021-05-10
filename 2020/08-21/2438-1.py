# 별 뒤에서부터 찍기

get = int(input())
a = "*"
b = " "
c = get - 1

for i in range(1,get+1):
    print(b*c+i*a)
    c = c - 1