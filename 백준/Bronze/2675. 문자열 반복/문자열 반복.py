tc = int(input())

for _ in range(tc):
    num, st = input().split(" ")
    num = int(num)
    ch = list(st)
    for word in ch:
        for _ in range(num):
            print(word, end = "")
    print("")