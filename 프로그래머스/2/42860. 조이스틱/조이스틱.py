def solution(name):
    
    shift = len(name) - 1
    answer = 0

    for idx, n in enumerate(name):

      answer += min(ord(n) - ord('A'), ord('Z') - ord(n) + 1)

      cnt = idx + 1
      while cnt < len(name):
        
        if(name[cnt] != "A"):
          break
        
        cnt += 1
      
      shift = min((shift, 2 * idx + len(name) - cnt, 2 * (len(name) - cnt) + idx))


    answer += shift
    return answer

solution("JEROEN"	)