num, com = map(int, input().split())

data = list(map(int, input().split()))

for i in data:
    if i < com:
        print(i, end = " ")