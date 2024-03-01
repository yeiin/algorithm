from collections import defaultdict

def solution(n, results):
    answer = 0
    dic = defaultdict()

    for i in range(1,n+1):
      dic[i] = [set(),set()]
    
    for result in results:
      dic[result[0]][0].add(result[1])
      dic[result[1]][1].add(result[0])

    
    for item in dic:
      for i in dic[item][0]:
        # dic[item][0] = dic[item][0].union(dic[i][0])
        dic[i][1].update(dic[item][1])
      for j in dic[item][1]:
        dic[j][0].update(dic[item][0])
    

    # print(dic)
    for item in dic:
      d = dic[item]
      if(len(d[0])+len(d[1]) == n-1):
        answer += 1

    return answer