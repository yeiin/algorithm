import sys
from collections import defaultdict, deque

ladderSnake = defaultdict(int)
visited = [-1 for i in range(101)]

q = deque([1])
visited[1] = 0

n, m = map(int, input().split())
horse = 1

for i in range(n+m):
    start, end = map(int, input().split())
    ladderSnake[start] = end


while q:
    now = q.popleft()

    for i in range(1, 7):
        next = now + i

        if (next <= 100) and (visited[next] == -1) :

            if next in ladderSnake:
                next = ladderSnake[next]
            
            if visited[next] == -1:
                q.append(next)
                visited[next] = visited[now] + 1

print(visited[100])