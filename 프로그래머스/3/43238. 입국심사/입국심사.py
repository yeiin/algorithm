def solution(n, times):
    answer = 0
    start = 1
    end = max(times) * n

    while start <= end:
        mid = (start + end) // 2

        count = 0
        for time in times:
            count += mid // time
        
        if(count < n):
            start = mid + 1
        else:
            answer = mid
            end = mid - 1
    return answer