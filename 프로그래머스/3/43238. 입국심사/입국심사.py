def solution(n, times):
    start = 1
    answer = 0
    end = max(times) * n

    while start <= end:
        mid = (start + end) // 2

        count = 0
        for time in times:
            count += mid //time
        
        if(count < n):
            start = mid + 1
        else:
            answer = mid
            end = mid - 1
    return answer