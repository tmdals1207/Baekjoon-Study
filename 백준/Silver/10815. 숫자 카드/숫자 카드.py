n = int(input())
sg = set(map(int, input().split()))
m = int(input())
co = list(map(int, input().split()))

for i in co:
  if i in sg:
    print(1, end=' ')
  else:
    print(0, end=' ')