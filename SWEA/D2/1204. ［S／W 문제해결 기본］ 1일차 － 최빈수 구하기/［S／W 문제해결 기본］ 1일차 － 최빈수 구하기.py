case = int(input())

for i in range(case):
  testNum = int(input())
  numbers = list(map(int, input().split()))
  numbers.sort()
  arr = [0] * 101
  max_value = 0

  for j in numbers:
    arr[j] += 1
  max_value = max(arr)
  result = 0
  for k in range(101):
    if arr[k] == max_value:
      result = k
  print(f"#{testNum} {result}")