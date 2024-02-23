from collections import deque

def solution(n, wires):
    answer = 10000
    
    for wire in wires:
      temp = wires.copy()
      temp.remove(wire)
      temp = deque(temp)

      left = [wire[0]]
      right= [wire[1]]
      count = 0
      while temp:
        
        item = temp.popleft()
        if(item[0] in left):
          left.append(item[1])
        elif(item[0] in right):
          right.append(item[1])
        elif(item[1] in left):
          left.append(item[0])
        elif(item[1] in right):
          right.append(item[0])
        else:
          temp.append(item)
        
          
      count = abs(len(left) - len(right))
      answer = min(answer, count)
    return answer