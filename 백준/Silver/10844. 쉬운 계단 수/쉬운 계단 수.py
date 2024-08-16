import sys

N = input()

i = 1
arr = [[ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1]]

for k in range(1, int(N)):
  arr.append([0 for i in range(10)])


while True:
  if(i == int(N)):
    print(sum(arr[i-1])%1000000000)
    break

  for j in range(10):
    if j == 0:
      arr[i][j] = arr[i-1][j+1]
    elif j == 9:
      arr[i][j] = arr[i-1][j-1]
    else:
      arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1]
  
  i += 1