def fib (n):
  if n == 0:
    return 0
  elif n == 1 or n == 2:
    d[n] = 1
    return d[n]
  elif d[n] != 0:
    return d[n]
  else:
    d[n] = fib(n - 2) + fib(n - 1)
    return d[n]

num = int(input())
d = [0] * (num + 1)
print(fib(num))