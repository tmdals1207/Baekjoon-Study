tc = int(input())

for i in range(1, tc + 1):
    size = int(input())
    board = [[0] * size for _ in range(size)]

    x, y, di = 0, 0, 0
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    for num in range (1, size * size + 1):
        board[x][y] = num
        nx, ny = x + dx[di], y + dy[di]

        if nx < 0 or nx >= size or ny < 0 or ny >= size or board[nx][ny] != 0:
            di = (di + 1) % 4
            nx, ny = x + dx[di], y + dy[di]

        x, y = nx, ny

    print(f'#{i}')
    for row in board:
        print(" ".join(map(str, row)))