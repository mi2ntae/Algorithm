# 소수의 연속합 (two pointer, 에라토스테네스의 체)

N = int(input())

ssous = [True for _ in range(N+1)]
ssous[0] = False
ssous[1] = False
sosu = []

for i in range(2, N+1):
    if ssous[i]:
        sosu.append(i)
        idx = 2
        while i * idx < N+1:
            ssous[i*idx] = False
            idx += 1

aa = len(sosu)
sosu.append(0)
head = 0
tail = 0
sumv = sosu[0]
ans = 0

while head < aa:
    if sumv == N:
        ans += 1
        head += 1
        sumv += sosu[head]
        sumv -= sosu[tail]
        tail += 1
        
    elif sumv < N:
        head += 1
        sumv += sosu[head]
    else:
        sumv -= sosu[tail]
        tail += 1

print(ans)