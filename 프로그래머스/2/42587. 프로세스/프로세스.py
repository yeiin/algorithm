def solution(priorities, location):
    answer = 0
    queue = [(i, prior) for i, prior in enumerate(priorities)]
    maxPrio = max(queue, key=lambda x:x[1])

    while True:
        temp = queue.pop(0)
        if(temp == maxPrio):
            answer += 1
            if(temp[0] == location):
                break
            maxPrio = max(queue, key=lambda x:x[1])
        else:
            queue.append(temp)

    return answer
            