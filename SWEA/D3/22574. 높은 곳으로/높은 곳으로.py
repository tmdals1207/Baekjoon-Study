tc = int(input())

for t in range(tc):
    n, p = map(int, input().split())
    total = 0
    for i in range(1, n + 1):
        total += i
        if total == p:
            total -= 1
    print(total)