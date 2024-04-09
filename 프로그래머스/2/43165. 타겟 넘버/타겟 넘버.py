count = 0

def dfs(numbers, target, num, index):
    global count

    if(index == len(numbers)):
        if(num == target):
          count += 1
        return
    
    temp = numbers[index]
    index += 1
    
    dfs(numbers, target, num + temp, index)
    dfs(numbers, target, num - temp, index)

def solution(numbers, target):
    
    dfs(numbers, target, 0, 0)
    return count
