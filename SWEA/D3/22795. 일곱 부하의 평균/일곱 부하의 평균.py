testcase = int(input())

for tc in range(1, testcase+1):
    burdens = list(map(int, input().split()))
    bur_7 = max(burdens) + 1
    total = sum(burdens)

    for i in range(0, 7):
        if (total + (bur_7 + i)) % 7 == 0:
            print(bur_7 + i)
            break 