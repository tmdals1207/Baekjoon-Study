from collections import deque

testcase = int(input())
answer = []

for tc in range(1, testcase+1):
    words = input().strip()
    queue = deque(words)
    count = int(input())
    total = sum(map(int, input().split()))

    length = len(queue)
    total = total % length
    if total > 0 :
        for _ in range(total):
            tmp = queue.popleft()
            queue.append(tmp)
    elif total < 0:
        for _ in range(-total):
            tmp = queue.pop()
            queue.appendleft(tmp)
    answer.append(queue)
for w in answer:
    print("".join(w))