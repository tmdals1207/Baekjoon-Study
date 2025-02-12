n = int(input())

result = 0                                  # 한수의 개수

for i in range(1, n + 1):
    if i < 100:                             # 두 자리 수 이하는 항상 한 
        result += 1
    else:
        tmp = 0                             # 한수가 아닐 시 1로 변경
        str_i = str(i)
        for j in range(len(str_i) - 2):     # 앞에서부터 3개의 숫자를 꺼내 등차수열인지 비교
            if int(str_i[j + 1]) - int(str_i[j]) != int(str_i[j + 2]) - int(str_i[j + 1]):
                tmp = 1
                break
        if tmp == 0:
            result += 1

print(result)