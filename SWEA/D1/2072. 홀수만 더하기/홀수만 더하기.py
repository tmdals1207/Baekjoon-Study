tc = int(input())

for i in range(1, tc + 1):
    data = list(map(int, input().split()))
    total = 0
    for num in data:
        if num % 2 == 1 :
            total += num
    print(f'#{i} {total}')