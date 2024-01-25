def solution(prices):
    answer = []
    for idx, price in enumerate(prices):
        answer.append(0)
        for j in range(idx+1, len(prices)):
            answer[idx]+=1
            if(price>prices[j]):
                break
            
    return answer