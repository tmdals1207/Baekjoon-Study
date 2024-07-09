def dfs(student, start, visited, finished, team):
    stack = []
    stack.append(start)
    while stack:
        current = stack[-1]
        if not visited[current]:
            visited[current] = True
            next_student = student[current]
            if not visited[next_student]:
                stack.append(next_student)
            elif not finished[next_student]:

                cycle = []
                while stack:
                    member = stack.pop()
                    cycle.append(member)
                    if member == next_student:
                        break

                if next_student in cycle:
                    for member in cycle:
                        team.add(member)
        else:
            finished[current] = True
            stack.pop()

num = int(input())
for _ in range(num):
    n = int(input())
    student = list(map(int, input().split()))
    student = [s - 1 for s in student]

    visited = [False] * n
    finished = [False] * n
    team = set()

    for i in range(n):
        if not visited[i]:
            dfs(student, i, visited, finished, team)

    print(n - len(team))