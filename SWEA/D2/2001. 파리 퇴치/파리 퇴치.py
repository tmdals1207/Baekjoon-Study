tc = int(input())

for tc in range(1, tc + 1):
    N, M = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(N)]

    max_sum = 0

    for i in range(N - M + 1):
        for j in range(N - M + 1):
            current_sum = 0
            for x in range(M):
                for y in range(M):
                    current_sum += graph[i + x][j + y]
            max_sum = max(max_sum, current_sum)

    print(f'#{tc} {max_sum}')