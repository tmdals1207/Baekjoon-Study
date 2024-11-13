def dfs(start, visited, graph):
    visited[start] = True
    count = 1
    for i in graph[start]:
        if not visited[i]:
            count += dfs(i, visited, graph)
    return count

cpu = int(input())
pair = int(input())

graph = [[] for _ in range(cpu + 1)]


for _ in range(pair):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (cpu + 1)
infected_cnt = dfs(1, visited, graph) - 1
print(infected_cnt)