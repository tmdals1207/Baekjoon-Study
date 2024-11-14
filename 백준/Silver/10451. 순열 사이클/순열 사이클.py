def dfs(start, graph, visited):
    stack = [start]
    while stack:
        current = stack.pop()
        if not visited[current]:
            visited[current] = True
            stack.append(graph[current])

testcase = int(input())

for i in range(testcase):
    size = int(input())
    data = list(map(int, input().split()))
    graph = [0] * (size + 1)

    for j in range(1, size + 1):
        graph[j] = data[j - 1]

    visited = [False] * (size + 1)
    count = 0

    for k in range(1, size + 1):
        if not visited[k]:
            dfs(k, graph, visited)
            count += 1

    print(count)
    visited = [False] * (size + 1)