def quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]

    left = []
    right = []
    equal = []
    for i in range(len(arr)):
        if(arr[i] == pivot):
            equal.append(pivot)
        else:

            temp1 = arr[i] * (10 ** len(str(pivot))) + pivot
            temp2 = pivot * (10 ** len(str(arr[i]))) + arr[i]
    
            if temp1 >= temp2:
                left.append(arr[i])
            elif temp1 < temp2:
                right.append(arr[i])
    return quicksort(left) + equal + quicksort(right)


def solution(numbers):
    answer = ''
    if(numbers.count(0)==len(numbers)):
        answer = "0"
    else:
        sortedNum = quicksort(numbers)
    
        answer = "".join(map(str, sortedNum))

    return answer