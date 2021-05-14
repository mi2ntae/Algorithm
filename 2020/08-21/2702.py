# 최소공배수 최대공약수 
# 유클리드 호제법
a = int(input())
b = []
c = []
for i in range(0,a):
    b.append(input())

    c = b[i].split()
    q1 = int(c[0])
    q2  = int(c[1])

    so = []
    da = []

    if q1 >= q2:
        m = q2
        n = q1
    else :
        m = q1
        n = q2


    for j in range(1,m+1):
        for l in range(1,n+1):
            if m*l==n*j :
                so.append(n*j)
                break
    t = m
    for k in range(1,m+1):
        if m%t == 0:
            if n%t == 0:
                da.append(t)
                break
        t -= 1
    print(so[0])
    print(da[0])
    
