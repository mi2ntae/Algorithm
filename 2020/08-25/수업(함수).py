def func(num):  # 인자 타입을 쓰지 않아도 됨
    return num + 1

def func1(num, exp=2, adv=0):    # 기본값을 설정 가능 다만, 기본 값이 없는 인자는 항상 기본 값이 있는 인자 앞으로 와야함
    return num**exp

print(func1(2,10))
print(func1(2))
print(func1(2, adv=2))

def func2(num, *args, exp=2):   # *파라미터는 튜플로 자기 뒤에 들어오는 값들을 묶어줌 (위치는 항상 기본 값 없는 애 뒤, 있는 애 앞)
    print("a")
    return 0
    
def func3(num, *args, exp=2, adv=0, **kwargs):   # **파라미터는 함수 호출 시 정의되지 않는 parameter를 사용할 때 모두 저장됨
    print(func3(2,3,4,exp=5,adv=2,mintae=100))
    return 0

def printall(*args, **kwargs):     
    for v in args:
        print(v)
    for k, v in kwargs.items():
        print(k, v)

print(printall("Hello", "World", name="mintae", age=20))

# 에라토스테네스의 체