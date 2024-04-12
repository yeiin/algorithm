def solution(numbers):
  num_arr = list(map(str, numbers))
  num_arr.sort(key=lambda x:x*3, reverse = True)
  

  answer = "".join(num_arr)
  if(answer[0]=="0"):
    return "0"
  return answer