from collections import deque

def solution(s):
  stack = deque()

  for c in s:
    if(c == '('):
      stack.append(c)
    else:
      if not stack:
        return False

      stack.pop()

  if stack:
    return False
  else:
    return True