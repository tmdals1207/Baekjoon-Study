from collections import deque

def dfs(graph, start, visited):
    stack = [start]
    while stack:
        v = stack.pop()
        if not visited[v]:
            visited[v] = True
            print(v, end=' ')
            for i in sorted(graph[v], reverse=True):
                if not visited[i]:
                    stack.append(i)

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in sorted(graph[v]):
            if not visited[i]:
                queue.append(i)
                visited[i] = True

n, m, start = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n + 1)
dfs(graph, start, visited)
print()
visited = [False] * (n + 1)
bfs(graph, start, visited)