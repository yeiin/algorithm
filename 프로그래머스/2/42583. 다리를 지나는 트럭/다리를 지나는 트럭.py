def solution(bridge_length, weight, truck_weights):
    answer = 0
    queue = []
    time_queue = []

    while True:
        if(len(truck_weights) == 0 and len(queue)==0):
            break
        answer += 1

        if(time_queue):
            time_queue = [i+1 for i in time_queue]

        if(time_queue != [] and time_queue[0] == bridge_length):
            queue.pop(0)
            time_queue.pop(0)

        if(truck_weights and sum(queue) + truck_weights[0] <= weight):
            truck = truck_weights.pop(0)
            queue.append(truck)
            time_queue.append(0)

    return answer