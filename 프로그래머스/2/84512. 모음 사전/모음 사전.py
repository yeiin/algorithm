from itertools import product

def solution(word):
    answer = 0
    alphabet = ['A', 'E', 'I', 'O', 'U']
    a_list = []
    for i in range(5):
        a_list.extend(list(product(alphabet, repeat=i+1)))
    a_list.sort()

    for i in a_list:
        answer += 1
        j = ''.join(i)
        if(j == word):
            break

    return answer