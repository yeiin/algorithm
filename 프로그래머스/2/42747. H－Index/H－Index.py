def solution(citations):
    citations.sort(reverse = True)

    for idx, i in enumerate(citations):
        if(idx >= i):
            return idx

    return len(citations)