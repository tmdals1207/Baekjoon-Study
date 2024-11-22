from collections import Counter

number = int(input())

for num in range(1, number + 1):
    numbers = list(str(num))
    counter = Counter(numbers)
    three = counter['3']
    six = counter['6']
    nine = counter['9']
    if three == 0 and six == 0 and nine == 0:
        print(num, end=" ")
    else:
        for _ in range(three + six + nine):
            print("-", end="")
        print(" ", end="")