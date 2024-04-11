from collections import deque

def solution(progresses, speeds):
  queue = deque()
  answer = []

  for idx,i in enumerate(progresses):
    count = 0
    while i < 100:
      i+=speeds[idx]
      count+=1
    queue.append(count)

  item = queue[0]
  count = 0

  while queue:
    temp = queue.popleft()

    if(item >= temp):
      count += 1
      if not queue:
        answer.append(count)

    else:
      answer.append(count)
      item = temp
      count = 1

      if not queue:
        answer.append(count)

  return answer