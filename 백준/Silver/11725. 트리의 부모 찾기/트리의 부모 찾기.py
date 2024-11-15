def dfs(graph, start, parents):
    stack = [start]
    while stack:
        current = stack.pop()
        for next in graph[current]:
            if parents[next] == 0:
                parents[next] = current
                stack.append(next)


n = int(input())

graph = [[] for i in range(n + 1)]

for _ in range(1, n):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

parents = [0] * (n + 1)

dfs(graph, 1, parents)

for i in range(2, n + 1):
    print(parents[i])