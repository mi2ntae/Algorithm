# 문자열

A,B = input().split()
ans = 51

for i in range(len(B)-len(A)+1):
    b = B[i:i+len(A)]
    count = 0
    for k in range(len(A)):
        if A[k] != b[k]:
            count += 1
    ans = min(ans,count)

print(ans)