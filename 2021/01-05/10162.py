# 전자레인지

T = int(input())
a = 0
b = 0
c = 0

while T >= 10:
    a += T//300
    T %= 300
    b += T//60
    T %= 60
    c += T//10
    T %= 10

if T == 0:
    print(a,b,c)
else:
    print(-1)