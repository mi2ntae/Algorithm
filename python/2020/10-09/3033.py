# 가장 긴 문자열

l = int(input())
L = input()

u = 2 ** 7 -1
v = 2 ** 31 -1
w = 2 ** 13 - 1
x = 2 ** 61 - 1


beg = 0
end = l

def isExist(string, length):
    global u, v

    hash_table = {}

    hkey = 0
    _hkey = 0
    for c in string[:length]:
        hkey = (hkey * u + ord(c)) % v
        _hkey = (_hkey * w + ord(c)) % x


    hash_table[(hkey, _hkey)] = True

    ru = (u ** (length - 1)) % v
    rw = (w ** (length - 1)) % x
    for i in range(length, len(string)):
        hkey = (hkey - (ord(string[i-length]) * ru) % v + v) % v
        _hkey = (_hkey - (ord(string[i-length]) * rw) % x + x) % x

        hkey = (hkey * u + ord(string[i])) % v
        _hkey = (_hkey * w + ord(string[i])) % x

        if hash_table.get((hkey, _hkey)) == length:
            return True
        hash_table[(hkey, _hkey)] = True

    return False

while end - beg > 1:
    mid = (beg + end) // 2
    
    if isExist(L, mid):
        beg = mid
    else:
        end = mid
                
print(beg)