count = 0

def bfs(numbers, target, num, index):
    global count

    if(index == len(numbers)):
        if(num == target):
          count += 1
        return
    
    temp = numbers[index]
    index += 1
    
    bfs(numbers, target, num + temp, index)
    bfs(numbers, target, num - temp, index)

def solution(numbers, target):
    
    bfs(numbers, target, 0, 0)
    return count
