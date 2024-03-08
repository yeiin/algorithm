def solution(number, k):
  stack = []
  l = len(number) - k

  for num in number:
  
      while stack and k > 0:
        top = stack[-1]
      
        if(top < num):
          k -= 1
          stack.pop(-1)
        else:
          break

      stack.append(num)
      
  stack = stack[:l]
  
  
  return ''.join(stack)