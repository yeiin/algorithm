import collections

def solution(participant, completion):
    participant_dict = collections.Counter(participant)
    completion_dict = collections.Counter(completion)
    
    for pkey, pvalue in participant_dict.items():
        if pvalue != completion_dict[pkey]:
            answer = pkey
            break
            
    return answer