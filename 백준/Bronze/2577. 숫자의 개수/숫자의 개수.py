from collections import Counter

a = int(input())
b = int(input())
c = int(input())

total = a * b * c

numbers = list(str(total))
counter = Counter(numbers)

print(counter[str("0")])
for i in range(1, 10):
    print(counter[str(i)])