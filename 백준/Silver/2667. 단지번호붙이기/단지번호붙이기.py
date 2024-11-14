from collections import deque


def bfs(i, j, graph, visited):
    queue = deque()
    queue.append((i,j))
    visited[i][j] = True
    cnt = 0

    dx = [0, -1, 0, 1]
    dy = [-1, 0, 1, 0]
    while queue:
        x, y = queue.popleft()
        cnt += 1
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))
    return cnt

size = int(input())

graph = [list(map(int, input().strip())) for _ in range(size)]

visited = [[False] * size for _ in range(size)]

total_count = 0
building_size = []
for i in range(size):
    for j in range(size):
        if graph[i][j] == 1 and not visited[i][j]:
            total_count += 1
            building_size.append(bfs(i, j, graph, visited))

building_size.sort()
print(total_count)
for size in building_size:
    print(size)