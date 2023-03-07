# 재귀 알파벳 말

r,c = input().split()
Row = int(r)
Column = int(c)
count = 0
MCount = 0
alphabet = [list(map(lambda x: ord(x)-ord("A") ,input())) for _ in range(Row)]
dx = [0, -1, 1, 0]
dy = [-1, 0, 0, 1]

def move(r, c, visited=0):
    global count, MCount
    global Column
    global Row  
    global dx, dy

    _visited = visited
    visited = visited | (1 << alphabet[r][c])

    count += 1
    MCount = max(MCount, count)

    for i in range(4):
        nx = c + dx[i]
        ny = r + dy[i]
        if nx != -1\
            and ny != -1 \
            and nx != Column \
            and ny != Row:
            if (visited & (1 << alphabet[ny][nx])) == 0:
                move(ny,nx,visited)
    count -= 1
    visited = _visited
    return

move(0,0)
print(MCount)
