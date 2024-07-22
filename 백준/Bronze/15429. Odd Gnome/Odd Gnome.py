tc = int(input())

for i in range(tc):
  arr = list(map(int, input().split()))
  length = int(arr[0])
  arr.pop(0)

  sample = []
  for j in range(1, length):
    if (arr[j - 1] + 1 != arr[j] and j != length - 1):
      print(j + 1)
      break