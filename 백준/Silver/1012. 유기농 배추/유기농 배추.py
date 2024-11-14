def dfs(start, graph, visited):
    stack = [start]

    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    while stack:
        x, y = stack.pop()
        if not visited[x][y]:
            visited[x][y] = True
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] == 1:
                    stack.append((nx, ny))


testcase = int(input())

for _ in range(testcase):
    m, n, k = map(int, input().split())
    graph = [[0] * n for _ in range(m)]
    for _ in range(k):
        x, y = map(int, input().split())
        graph[x][y] = 1

    visited = [[False] * n for _ in range(m)]
    count = 0

    for i in range(m):
        for j in range(n):
            if not visited[i][j] and graph[i][j] == 1:
                dfs([i, j], graph, visited)
                count += 1
    print(count)