# 오른차순, 내림차순 확인하기
input = input().split()

a = 0
num = 0
for i in input:
    b = int(i)
    if a == 0 :
        a = b
    else :
        if a < b :
            a = b
            num += 1
        else :
            a = b
            num -= 1

if num == 7:
    print("ascending")
elif num == -7:
    print("descending")
else :
    print("mixed")