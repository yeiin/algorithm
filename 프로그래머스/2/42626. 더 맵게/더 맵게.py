from heapq import heappush, heappop, heapify

def solution(scoville, K):
  heapify(scoville)
  count = 0

  while True:
    item = heappop(scoville)
    
    if(item >= K):
      break
    
    if(len(scoville)<1):
      return -1
    second = heappop(scoville)
    
    count += 1
    heappush(scoville, item + 2*second)


  return count