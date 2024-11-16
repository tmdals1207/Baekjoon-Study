from collections import deque
import sys

input = sys.stdin.read
data = input().splitlines()

queue = deque()

for command in data[1:]:
    if command.startswith("push"):
        _, x = command.split()
        queue.append(x)
    elif command == "pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif command == "size":
        print(len(queue))
    elif command == "empty":
        print(1 if not queue else 0)
    elif command == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif command == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)