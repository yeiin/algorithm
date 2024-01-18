import collections
def solution(phone_book):
    answer = True
    phoneDict = collections.Counter(phone_book)

    for number in phone_book:
        findKey = ""
        for num in number:
            findKey += num

            if findKey in phoneDict and findKey != number:
                return False
    
    return True
    
