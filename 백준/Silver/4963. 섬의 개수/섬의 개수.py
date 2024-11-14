from collections import deque

def dfs(start,  graph, visited, w, h):
    stack = ([start])

    directions = [(-1, 0), (1, 0), (0, -1), (0, 1),
                 (-1, -1), (-1, 1), (1, -1), (1, 1)]

    while stack:
        x, y = stack.pop()
        if not visited[x][y]:
            visited[x][y] = True
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and graph[nx][ny] == 1 :
                    stack.append((nx, ny))

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    graph = [[0] * w for _ in range(h)]
    visited = [[False] * w for _ in range(h)]

    for i in range(h):
        data = list(map(int, input().split()))
        graph[i] = data

    count = 0

    for j in range(h):
        for k in range(w):
            if not visited[j][k] and graph[j][k] == 1:
                dfs([j, k], graph, visited, w, h)
                count += 1
    print(count)