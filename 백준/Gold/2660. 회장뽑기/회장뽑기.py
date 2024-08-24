num = int(input())
graph = [[ 50 for _ in range(num)] for _ in range(num)]
score = [0 for _ in range(num)]


while True:
    n, m = map(int, input().split())

    if(n == -1 and m == -1):
        break

    graph[n-1][m-1] = 1
    graph[m-1][n-1] = 1


for i in range(num):
    graph[i][i] = 0


for i in range(num):
    for j in range(num):
        for k in range(num):
            graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k])

for i in range(num):
    score[i] = max(graph[i])

minimum = min(score)
print(minimum, end=" ")
print(score.count(minimum))

for i in range(num):
    if score[i] == minimum:
        print(i+1, end=" ")

