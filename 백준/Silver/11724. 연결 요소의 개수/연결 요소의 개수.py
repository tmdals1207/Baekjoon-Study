def dfs(i, con, visited):
    stack = [i]
    while stack:
        v = stack.pop()
        if not visited[v]:
            visited[v] = True

            for nei in con[v]:
                if not visited[nei]:
                    stack.append(nei)

n, m = map(int, input().split())

con = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    con[b].append(a)
    con[a].append(b)

cnt = 0

visited = [False] * (n + 1)

for i in range(1, n + 1):
    if not visited[i]:
        dfs(i, con, visited)
        cnt += 1

print(cnt)