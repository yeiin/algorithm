from collections import deque

def solution(priorities, location):
  queue = []

  for idx, num in enumerate(priorities):
    queue.append((num, idx))

  q = deque(queue)
  count = 1
  m = max(q, key=lambda x: x[0])
  cnt = q.count(m)


  while True:

    item = q.popleft()

    if( (item[0] == m[0])):

      if(item[1] == location):
        return count
      elif(cnt > 1):
        q.append(item)
      else:
        count += 1

      m = max(q, key=lambda x: x[0])
      cnt = q.count(m)


    else:
      q.append(item)