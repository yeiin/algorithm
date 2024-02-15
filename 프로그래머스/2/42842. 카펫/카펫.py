def solution(brown, yellow):
    answer = []
    
    total = brown + yellow

    for i in range(3, total):
        width = int(total / i)
        if(total % i == 0 and (i-2)*(width-2)==yellow):
            answer.append(width)
            answer.append(i)
            break
    return answer
    
    
    return answer