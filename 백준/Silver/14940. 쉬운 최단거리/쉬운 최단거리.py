from collections import deque

def bfs(board, start, n, m):
  queue = deque([start])
  distances = [[-1] * m for _ in range(n)]
  distances[start[0]][start[1]] = 0

  dx = [1, -1, 0, 0]
  dy = [0, 0, 1, -1]
  
  while(queue):
    x, y = queue.popleft()

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if(0 <= nx < n and 0 <= ny < m and board[nx][ny] == 1 and distances[nx][ny] == -1):
        distances[nx][ny] = distances[x][y] + 1
        queue.append((nx, ny))

  for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            distances[i][j] = 0
  
  return distances
    

n, m = map(int, input().split())

board = []
start = None

for i in range(n):
  row = list(map(int, input().split()))
  board.append(row)
  for j in range(m):
      if row[j] == 2:
          start = (i, j)


distances = bfs(board, start, n, m)

for row in distances:
    print(' '.join(map(str, row)))