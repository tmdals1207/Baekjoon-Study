data = [0] * 9
big = 0
big_index = 0
for i in range(9):
    data[i] = int(input())
    if data[i] > big:
        big = data[i]
        big_index = i + 1

print(big)
print(big_index)