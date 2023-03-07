a = [1,2,3,4]
b = list()

b.reverse()
c = list(reversed(b)) # 리버스 함수는 객체 생성 x

for k in a:
    print(a[k])
    print(a[-k-1])

print(a[::-1]) # 새로운 객체
print(a[::3]) # 새로운 객체

print(range(10))
print(list(range(10)))

for m, n in enumerate(c): # m=인덱스 n=밸류
    print(m)
# :는 slice 새로운 객체
print(a[1:2])
print(a[2:])
print(a[:2])
print(a[:])

# list comprehension
O = ["first", "second", "third", "fourth"]
L = [v for v in O]  # 리스트를 순환하여 새로운 리스트 동적 생성
L = [v.upper() for v in O if[O[0]]]

O.append("fifth")   
O.extend(["fifth,", "sixth"])
O += ["fifth", "sixth"]   # 배열 덧셈이 가능
O *= 2  # 2번 반복됨

ll = [[None] * 10] * 10     # 2차원 배열인데 이렇게 만들면 참조하는 배열을 10개 만들기 때문에 X
ll = [[None] * 10 for i in range(10)]   # 2차원 배열인데 계속 새로 생성하기 때문에 O

print(ll[0][0])