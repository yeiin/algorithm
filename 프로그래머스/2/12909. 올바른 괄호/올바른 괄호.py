def solution(s):
    answer = True
    stack = []
    
    for char in s:
        if(char == ')'):
            if(len(stack) == 0):
                answer = False
                break
            else:
                stack.pop()
                answer = True
        else:
            stack.append(char)
    
    if(len(stack)!=0):
        answer = False
        
    return answer