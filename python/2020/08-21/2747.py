# 피보나치

a = 0
b = 1

get = int(input())

for i in range(0,get-2):
    c = b
    b = b+a
    a = c

print(b)
