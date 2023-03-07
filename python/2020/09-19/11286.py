# 절댓값 힙

import sys
input = sys.stdin.readline
myHeap = [0]

class MyHeap():
    def juldae(val):
        if juldae < 0:
            return -val
        return val

    def isFirstSmaller(a, b):
        if juldae(a) == juldae(b):
            return a < b
        return juldae(a) < juldae(b)

    @staticmethod
    def push(heap, value):
        cur = len(heap)
        heap.append(value)
        if cur == 1:
            return

        while cur > 1:
            if isFirstSmaller(heap[cur], heap[cur//2]):
                heap[cur],heap[cur//2] = heap[cur//2],heap[cur]
                cur //= 2
            else:
                break

    @staticmethod
    def pop(heap):
        val = heap[1]
        if len(heap) == 2:
            return heap.pop()
        heap[1] = heap.pop()
        cur = 1
        while True:
            if cur*2 >= len(heap):
                break

            if cur*2 == len(heap)-1:
                if MyHeap.isFirstSmaller(heap[cur*2], heap[cur]):
                    heap[cur],heap[cur*2] = heap[cur*2],heap[cur]
                    cur *= 2
                break
            else:
                if isFirstSmaller(heap[cur*2], heap[cur*2+1]):
                    if isFirstSmaller(heap[cur*2], heap[cur]):

        
                elif leftval <= rightval and leftval <= curval:
                    if leftval == curval:
                        if leftval < curval:
                            heap[cur],heap[cur*2] = heap[cur*2],heap[cur]
                            cur = cur*2
                    elif leftval < curval:
                        heap[cur],heap[cur*2] = heap[cur*2],heap[cur]
                        cur = cur*2
                    else:
                        break
                else:
                    break
        return val


N = int(input())

for _ in range(N):
    x = int(input())

    if x == 0:
        if len(myHeap) == 1:
            print("0")
        else:
            print(MyHeap.pop(myHeap))
    else:
        MyHeap.push(myHeap, x)