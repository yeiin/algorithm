import heapq

def solution(jobs):
    answer = 0
    time = -1 
    current = 0
    idx = 0
    heap = []

    while (idx < len(jobs)):
        for job in jobs:
            if(time < job[0] <= current):
                heapq.heappush(heap,[job[1], job[0]])

        if(heap):
            temp = heapq.heappop(heap)
            time = current
            current += temp[0]
            idx += 1
            answer += (current - temp[1])
        else:
             current += 1
    return answer // len(jobs)