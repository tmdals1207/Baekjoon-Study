def dfs(value, start, visited):
  stack = [start]
  while stack:
    v = stack.pop()
    if(not visited[v]):
      visited[v] = True
      
      for neighbor in value[v]:
        if not visited[neighbor]:
            stack.append(neighbor)

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

cnt = 0
visited = [False] * (n + 1)
for i in range(1, n + 1):
    if not visited[i]:
        dfs(graph, i, visited)
        cnt += 1

print(cnt)