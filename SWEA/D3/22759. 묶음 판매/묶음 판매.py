tc = int(input())

for i in range(1, tc + 1):
    l, r = map(int, input().split())

    x = r + 1

    if l % x >= x / 2 and r % x >= x / 2:
        print("yes")
    else:
        print("no")