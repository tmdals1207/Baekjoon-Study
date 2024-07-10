import sys 
from collections import deque

def bfs(graph, visited, start, w, h):
  queue = deque([start])
  directions = [(-1, 0), (1, 0), (0, -1), (0, 1), 
    (-1, -1), (-1, 1), (1, -1), (1, 1)]
  while queue:
    x, y = queue.popleft()
    if not visited[x][y]:
      visited[x][y] = True
      for dx, dy in directions:
        nx, ny = x + dx, y + dy
        if(0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and graph[nx][ny] == 1):
          queue.append((nx, ny))

while (True):
  w, h = map(int, input().split())
  if (w == 0 and h == 0):
    break

  graph = []
  visited = [[False] * w for _ in range(h)]

  for _ in range(h):
    row = list(map(int, input().split()))
    graph.append(row)
  cnt = 0
  for i in range(h):
    for j in range(w):
      if(not visited[i][j] and graph[i][j] == 1):
        bfs(graph, visited, [i, j], w, h)
        cnt += 1
  print(cnt)