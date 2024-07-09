from collections import deque

def bfs(board, visited, i, j):
    queue = deque()
    queue.append((i, j))
    cnt = 0
    visited[i][j] = True

    while queue:
        x, y = queue.popleft()
        cnt += 1
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))
    return cnt

n = int(input())
board = []
for _ in range(n):
    row = list(map(int, input().strip()))
    board.append(row)

visited = [[False] * n for _ in range(n)]

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

components = []
for i in range(n):
    for j in range(n):
        if board[i][j] == 1 and not visited[i][j]:
            components.append(bfs(board, visited, i, j))

components.sort()
print(len(components))
for component in components:
    print(component)