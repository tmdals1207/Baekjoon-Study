count = int(input())

lines = [tuple(map(int, input().split())) for _ in range(6)]

max_len = 0
max_wid = 0

small_length = 0
small_width = 0

for i in range(6):
    di, m = lines[i]
    next_di, next_m = lines[(i + 1) % 6]

    if di == 1 or di == 2:
        if max_wid < m:
            max_wid = m
            small_width = abs(lines[(i - 1) % 6][1] - lines[(i + 1) % 6][1])

    else:
        if max_len < m:
            max_len = m
            small_length = abs(lines[(i - 1) % 6][1] - lines[(i + 1) % 6][1])

big_area = max_len * max_wid
small_area = small_length * small_width
real_area = big_area - small_area
total_count = real_area * count

print(total_count)