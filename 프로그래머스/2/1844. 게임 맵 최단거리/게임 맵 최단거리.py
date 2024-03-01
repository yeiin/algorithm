from collections import deque
  
def solution(maps):
    stack = deque()
    if(maps[0][0] == 0):
        return -1
    
    stack.append((0,0))

    width = len(maps[0])-1
    height = len(maps) -1
    vec = [(-1, 0), (0, -1), (1, 0), (0,1)]

    while stack:
    
        item = stack.popleft()

        for k in vec:
            x = item[0] + k[0]
            y = item[1] + k[1]
            if((0 <= x <= height) and (0 <=y<= width) and (maps[x][y] == 1) and ((x,y) != (0,0))):
                stack.append((x,y))
                maps[x][y] = maps[item[0]][item[1]] + 1
        

                
    if(maps[height][width]==1):
        return -1
    else:
        return maps[height][width]