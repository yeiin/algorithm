from collections import Counter

def solution(nums):
    nums_dict = Counter(nums)
    answer = 0
    
    if len(nums_dict) < len(nums)/2:
        answer = len(nums_dict)
    else:
        answer = len(nums)/2
    
    return answer