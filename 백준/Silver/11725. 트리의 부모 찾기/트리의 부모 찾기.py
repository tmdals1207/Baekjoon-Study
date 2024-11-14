def dfs(graph, start, parents):
    stack = [start]
    while stack:
        current = stack.pop()
        for next in graph[current]:
            if parents[next] == 0:
                parents[next] = current
                stack.append(next)

node = int(input())

graph = [[] for _ in range(node + 1)]

for _ in range(node - 1):
    a, b = map(int, input().split())
    graph[b].append(a)
    graph[a].append(b)

parents = [0] * (node + 1)

dfs(graph, 1, parents)

for i in range(2, node + 1):
    print(parents[i])