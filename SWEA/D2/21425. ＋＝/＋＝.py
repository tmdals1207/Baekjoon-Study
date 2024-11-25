tc = int(input())

for tc in range(1, tc + 1):
    x, y, n = map(int, input().split())

    count = 0

    if x > n or y > n:
        count = 1
        break
        
    if x < y:
        while True:
            x += y
            count += 1
            if x > n:
                break
            y += x
            count += 1
            if y > n:
                break
    else:
        while True:
            y += x
            count += 1
            if y > n:
                break
            x += y
            count += 1
            if x > n:
                break
    print(count)