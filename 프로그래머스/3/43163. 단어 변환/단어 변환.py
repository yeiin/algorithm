from collections import deque

def solution(begin, target, words):
    answer = 0
    queue = deque()
    queue.append((begin, 0))
    
    if(target not in words): 
      return 0

    while queue:
      item = queue.popleft()

      if(item[0] == target):
        answer = item[1]
        break
      
      
      for word in words:
        count = 0
        for i in range(len(word)): 
          if(word[i] != item[0][i]):
            count += 1

      
        if(count == 1):
          queue.append((word, item[1]+1))
      
    return answer