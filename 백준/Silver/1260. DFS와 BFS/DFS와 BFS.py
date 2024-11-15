from collections import deque


def dfs(board, visited, v):
    stack = [v]
    while stack:
        v = stack.pop()
        if not visited[v]:
            visited[v] = True
            print(v, end=' ')
            for value in sorted(board[v], reverse=True):
                if not visited[value]:
                    stack.append(value)

def bfs(board, visited, v):
    queue = deque([v])
    while queue:
        v = queue.popleft()
        if not visited[v]:
            visited[v] = True
            print(v, end=' ')
            for value in sorted(board[v]):
                if not visited[value]:
                    queue.append(value)

n, m, v = map(int, input().split())

board = [[] for _ in range(n + 1)]

for i in range(m):
    a, b = map(int, input().split())
    board[a].append(b)
    board[b].append(a)

visited = [False] * (n + 1)

dfs(board, visited, v)
print()
visited = [False] * (n + 1)
bfs(board, visited, v)