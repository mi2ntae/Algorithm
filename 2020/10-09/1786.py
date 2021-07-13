# 찾기 (Rabin Carp)

import sys
input = sys.stdin.readline
u = 2 ** 7 - 1
v = 2 ** 31 - 1

w = 257
x = int(1e9)+7

ans = []

S = input()[:-1]
T = input()[:-1]

Tkey = 0
_Tkey = 0
for t in T:
    Tkey = (Tkey * u + ord(t)) % v
    _Tkey = (_Tkey * w + ord(t)) % x

Skey = 0
_Skey = 0
for s in S[:len(T)]:
    Skey = (Skey * u + ord(s)) % v
    _Skey = (_Skey * w + ord(s)) % x

if Tkey == Skey and _Tkey == _Skey:
    ans.append(1)

ex = (u ** (len(T)-1)) % v
_ex = (w ** (len(T)-1)) % x

for i in range(len(T), len(S)):
    Skey = Skey - (ord(S[i-len(T)]) * ex) % v + v
    Skey = (Skey * u + ord(S[i])) % v
    _Skey = _Skey - (ord(S[i-len(T)]) * _ex) % x + x
    _Skey = (_Skey * w + ord(S[i])) % x
    # print(Tkey, Skey, T, S[i - len(T) + 1 : i + 1])
    if Tkey == Skey and _Tkey == _Skey:
        ans.append(i - len(T) + 2)

print(len(ans))
print(" ".join(map(str, ans)))