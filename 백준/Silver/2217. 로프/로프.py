n = int(input())

li = [int(input()) for _ in range(n)]

li.sort(reverse=True)

max_weight = 0
for i in range(n):
    max_weight = max(max_weight, li[i] * (i + 1))

print(max_weight)