A = int(input())
sub = list(map(int, input().split()))
lis = []

def lb(num):
    beg = 0
    end = len(lis)-1
    if num < lis[0]:
        lis[0] = num

    while end-beg > 1:
        mid = (end+beg)//2
        if lis[mid] < num:
            beg = mid
        else:
            end = mid

    if lis[beg] < num:
        lis[end] = num
    

for num in sub:
    if len(lis) == 0:
        lis.append(num)
    else:
        if lis[-1] < num:
            lis.append(num)
        else:
            lb(num)

print(len(lis))