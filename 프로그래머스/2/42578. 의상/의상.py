import collections

def solution(clothes):
    answer = 1
    tempList = []
    for cloth in clothes:
        tempList.append(cloth[1])
    
    countDict = collections.Counter(tempList)
    
    for item in countDict.values():
        answer *= (item+1)
    
    return answer -1
