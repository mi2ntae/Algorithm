# 요일 맞추기

b,c = input().split()
b = int(b)
c = int(c)

m = 0

day = [0,31,28,31,30,31,30,31,31,30,31,30,31]
aa = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]

for i in range(1,b):
    m = m+day[i]

m = (m+c)%7
print(aa[m])

