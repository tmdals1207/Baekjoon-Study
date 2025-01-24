for tc in range(1, 11):
    dump = int(input())
    height = list(map(int, input().split()))

    dif = 0

    for i in range(dump):
        max_h = max(height)
        min_h = min(height)

        if max_h == min_h:
            break

        height[height.index(max_h)] -= 1
        height[height.index(min_h)] += 1

    dif = max(height) - min(height)
    print(f"#{tc} {dif}")