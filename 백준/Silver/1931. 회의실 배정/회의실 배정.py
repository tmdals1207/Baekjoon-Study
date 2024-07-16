count = int(input())

arr = []
max = 0

for _ in range(count):
  row = list(map(int, input().split()))

  arr.append(row)

arr.sort(key = lambda x : (x[1], x[0]))

endTime = 0

for start, end in arr:
  if(start >= endTime):
    endTime = end
    max += 1

print(max)