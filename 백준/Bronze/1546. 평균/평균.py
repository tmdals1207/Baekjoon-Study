cnt = int(input())

score = list(map(int, input().split()))
max_score = max(score)

total = 0
for sc in score:
    sc = sc / max_score * 100
    total += sc

print(total / cnt)