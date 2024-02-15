from itertools import permutations

def solution(k, dungeons):
    answer = -1
    
    for i in permutations(dungeons, len(dungeons)):
        tempK = k
        tempAnswer = 0
        for j in i:
            if(tempK >= j[0]):
                tempAnswer +=1
                tempK -= j[1]
        
        if(tempAnswer > answer):
            answer = tempAnswer

    return answer