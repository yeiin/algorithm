count = 0

def bfs(n, computers, nodes, index):
    if(nodes[index] == True):
        return
    else:
        nodes[index] = True
    
    for idx, j in enumerate(computers[index]):
        if((j==1) and (idx != index)):
            bfs(n, computers, nodes, idx)

def solution(n, computers):
    global count 
    nodes = [False for i in range(n)]

    for i in range(n):
        if(nodes[i] == False):
            count += 1
            bfs(n, computers, nodes, i)
    
    return count