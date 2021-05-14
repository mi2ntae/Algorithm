# 수 뒤집기
m = int(input())
for g in range(m):
    k = int(input())
    b = k
    a = 0
    while k != 0:
        a = 10*a + k%10
        k = k//10

    c = a + b
    l = c
    k = 0
    while c != 0:
        k = 10*k + c%10
        c = c//10

    if l==k:
        print("YES")
    else :
        print("NO")
