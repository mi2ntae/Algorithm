# 별찍기
a = int(input())

star = "*"
blank = " "
k = 1
for i in range(0,a):
    print(i*blank+(2*a-k)*star)
    k += 2


