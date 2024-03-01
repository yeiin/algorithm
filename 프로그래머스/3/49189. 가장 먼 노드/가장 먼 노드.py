from collections import deque 

def solution(n, edge):
    answer = 0
    arr = [[] for i in range(n+1)]
    visited = [0 for i in range(n+1)] 

    for e in edge:
      arr[e[0]].append(e[1])
      arr[e[1]].append(e[0])
    
    
    visited[1] = 1
    q = deque()
    q.append(1)

    while q:
      item = q.popleft()

      for a in arr[item]:
        if(not visited[a]):
          visited[a] = visited[item] + 1
          q.append(a)
    
   
    answer = visited.count(max(visited))
    return answer