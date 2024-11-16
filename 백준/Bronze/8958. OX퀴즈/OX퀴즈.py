tc = int(input())

for _ in range(tc):
    data = input()
    result = list(data)
    score = 0
    con = 0

    for i in result:
        if i == "O":
            score += con + 1
            con +=1
        else:
            con = 0

    print(score)