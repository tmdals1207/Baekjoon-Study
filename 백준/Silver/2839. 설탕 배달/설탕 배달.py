def sugar_delivery(n):
    for i in range(n // 5, -1, -1):
        remainder = n - (i * 5)
        if remainder % 3 == 0:
            return i + (remainder // 3)
    return -1

n = int(input())
print(sugar_delivery(n))