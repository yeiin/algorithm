def solution(operations):
    answer = []
    nums = []
    
    for oper in operations:
        temp = oper.split()
        if(temp[0] == "I"):
            nums.append(int(temp[1]))
        elif nums:
            if(temp[1] == "1"):
                nums.remove(max(nums))
            else:
                nums.remove(min(nums))
    
    if not nums:
        answer = [0,0]
    else:
        answer.append(max(nums))
        answer.append(min(nums))
    
    return answer