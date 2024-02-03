from itertools import permutations

def isDecimal(num):
    if(num <= 1):
        return False 
    for i in range(2, num):
        if num%i == 0:
            return False    
    return True

def solution(numbers):
    answer = 0
    num_list = list(numbers)
    all_num = []

    for i in range(len(num_list)):
        outcomes = permutations(num_list, i+1)
        for outcome in outcomes:
            number = int(''.join(outcome))
            all_num.append(number)
    
    all_num = list(set(all_num))

    for number in all_num:
        if isDecimal(number):
            answer+=1
    return answer