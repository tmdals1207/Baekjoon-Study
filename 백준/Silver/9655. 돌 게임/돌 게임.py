def stone(n):
  d = n
  cnt = 0
  while (d != 0):
    if (d >= 3):
      d -= 3
      cnt += 1
    else:
      d -= 1
      cnt += 1
  return cnt


num = int(input())

if (stone(num) % 2 == 0):
  print("CY")
else:
  print("SK")