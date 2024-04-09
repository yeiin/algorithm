from collections import Counter

def solution(participant, completion):
    participant_dict = Counter(participant)
    completion_dict = Counter(completion)
    
    for pkey, pvalue in participant_dict.items():
        if pvalue != completion_dict[pkey]:
            answer = pkey
            break
            
    return answer