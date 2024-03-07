def solution(n, lost, reserve):
    answer = 0
    arr = [1] * n

    for i in lost:
      arr[i-1] -= 1
    
    for j in reserve:
      arr[j-1] += 1

    for a in range(len(arr)):
        if((arr[a] > 1) and (a-1 > -1) and(arr[a-1] == 0)):
            arr[a] -= 1
            arr[a-1] += 1
        
        if ((arr[a] > 1) and (a+1 < len(arr)) and(arr[a+1] == 0)):
            arr[a] -= 1
            arr[a+1] += 1 
      
      

    answer = n - arr.count(0)
    return answer