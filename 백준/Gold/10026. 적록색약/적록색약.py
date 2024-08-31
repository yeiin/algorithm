from collections import deque

n = int(input())

picture = [list(input()) for _ in range(n)]
nvisited = [[ 0 for _ in range(n) ] for _ in range(n)]
visited = [[ 0 for _ in range(n) ] for _ in range(n)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

ncount = 0
count = 0

def nbfs(startnode):
    nq = deque()
    nq.append(startnode)
    global ncount
    ncount += 1
    
    while nq:
        nowx, nowy = nq.pop()

        for i in range(4):
            x = nowx + dx[i]
            y = nowy + dy[i]

            if 0<=x<n and 0<=y<n:
                if picture[nowx][nowy] == picture[x][y] and nvisited[x][y] == 0:
                    nvisited[x][y] = 1
                    nq.append((x, y))

def bfs(startnode):
    q = deque()
    q.append(startnode)
    global count
    count += 1
    
    while q:
        nowx, nowy = q.pop()

        for i in range(4):
            x = nowx + dx[i]
            y = nowy + dy[i]

            if 0<=x<n and 0<=y<n:
                if picture[nowx][nowy] == "R" or picture[nowx][nowy] == "G":
                    if(picture[x][y] == "R" or picture[x][y]=="G") and visited[x][y] == 0:
                        visited[x][y] = 1
                        q.append((x, y))
                elif picture[nowx][nowy]==picture[x][y] and visited[x][y] == 0:
                    visited[x][y] = 1
                    q.append((x, y))
    

for row in range(n):
    for col in range(n):
        if nvisited[row][col] == 0 :
            nbfs((row, col))
            
        if visited[row][col] == 0 :
            bfs((row, col))

print(ncount, count, sep=" ")