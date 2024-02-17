import heapq

def solution(scoville, K):
    answer = 0

    heapq.heapify(scoville)
    
    while True:
        temp1 = heapq.heappop(scoville)
        if(temp1 >= K):
            break
        else:
            answer += 1
            if(len(scoville) == 0):
                answer = -1
                break
            temp2 = heapq.heappop(scoville)
            heapq.heappush(scoville, temp1 + 2*temp2)
    
    return answer