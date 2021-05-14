p = input().split()

a = int(p[0])
b = int(p[1])
c = int(p[2])

print((a+b)%c)
print(((a%c)+(b%c))%c)
print((a*b)%c)
print(((a%c)*(b%c)%c))