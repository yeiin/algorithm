def solution(progresses, speeds):
    answer = []
    queue = []
    
    for idx, item in enumerate(progresses):
        count = 0
        while (item < 100):
            count += 1
            item += speeds[idx]
        queue.append(count)
    
    count = 0
    temp = queue[0]
    
    for i, j in enumerate(queue):
        if(temp >= j):
            count += 1

            if(i == len(queue)-1):
                answer.append(count)
        else:
            answer.append(count)
            count = 1
            if(i == len(queue)-1):
                answer.append(count)
            else:
                temp = j
    return answer