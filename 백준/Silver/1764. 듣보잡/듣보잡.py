N, M = map(int, input().split())

listenless = {input() for _ in range(N)}
seeless = {input() for _ in range(M)}
double = sorted(listenless & seeless)

print(len(double))

for i in double :
  print(i)