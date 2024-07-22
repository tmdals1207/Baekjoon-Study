tc = int(input())

for _ in range(tc):
  k = int(input())
  n = int(input())

  dp = []
  for i in range(n):
    dp.append(i + 1)

  for _ in range(k):
    for j in range(1, n):
      dp[j] = dp[j] + dp[j - 1]

  print(dp[n - 1])