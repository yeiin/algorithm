def solution(answers):
    answer = []
    score = [0,0,0]
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    for idx, i in enumerate(answers):
        if(i==one[idx%len(one)]):
            score[0] += 1
        if(i==two[idx%len(two)]):
            score[1] += 1
        if(i==three[idx%len(three)]):
            score[2] += 1
    

    for idx, i in enumerate(score):
        if(i== max(score)):
            answer.append(idx+1)
    return answer