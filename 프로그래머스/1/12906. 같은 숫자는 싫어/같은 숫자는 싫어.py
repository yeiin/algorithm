def solution(arr):
    answer = []
    stack = []
    
    for i in arr:
        if(len(stack) == 0):
            answer.append(i)
            stack.append(i)
        
        top = stack.pop()
        if(top != i):
            answer.append(i)
            stack.append(i)
        else:
            stack.append(i)
            
    return answer