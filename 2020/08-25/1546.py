# 평균 점수 구하기
get = int(input())

score = input().split()

high = 0
for i in range(get):
    if high <= int(score[i]):
        high = int(score[i])

result = 0
for l in range(get):
    g = int(score[l])/high*100
    result += g

print(result/get)



