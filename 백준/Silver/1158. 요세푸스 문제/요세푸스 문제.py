from collections import deque

n, k = map(int, input().split())

queue = deque(range(1, n + 1))
  
count = 0

answer = []

while queue :
  num = queue.popleft()
  count += 1

  if(count != k):
    queue.append(num)
  else:
    answer.append(num)
    count = 0

output = "<" + ", ".join(map(str, answer)) + ">"
print(output)