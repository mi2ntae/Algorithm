# 괄호

vps = 0
isVps = True

def VPS(str, idx):
    global vps, isVps
    if idx > len(str)-1:
        return
    
    if str[idx] == "(":
        vps += 1
    else:
        vps -= 1
    
    if vps < 0:
        isVps = False

    VPS(str, idx+1)
    return


T = int(input())

for i in range(T):
    vps = 0
    isVps = True
    inp = input()
    VPS(inp, 0)

    if vps == 0 and isVps == True:
        print("YES")
    else:
        print("NO")

