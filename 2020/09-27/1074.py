# Z


N,R,C = map(int, input().split())

def visit(N, r, c):
    global R,C
    if N == 0:
        return 1

    if c <= C and C < c+2**(N-1) and r <= R and R < r+2**(N-1):
        return visit(N-1, r, c)
    if c+2**(N-1) <= C and C < c+2**N and r <= R and R < r+2**(N-1):
        return visit(N-1, r, c+2**(N-1)) + 4**(N-1)
    if c <= C and C < c+2**(N-1) and r+2**(N-1) <= R and R < r+2**N:
        return visit(N-1, r+2**(N-1), c) + 2*(4**(N-1))
    return visit(N-1, r+2**(N-1), c+2**(N-1)) + 3*(4**(N-1))

print(visit(N, 0, 0)-1)




