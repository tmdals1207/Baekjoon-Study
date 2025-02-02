re = set()

for _ in range(10):
    num = int(input())
    re.add(num % 42)

print(len(re))