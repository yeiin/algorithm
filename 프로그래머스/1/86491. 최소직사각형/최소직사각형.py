def solution(sizes):
    answer = 0
    width = 0
    height = 0
    for card in sizes:
        card.sort()
        if(card[0] > width):
            width = card[0]
        if(card[1] > height):
            height = card[1]
    
    return width * height