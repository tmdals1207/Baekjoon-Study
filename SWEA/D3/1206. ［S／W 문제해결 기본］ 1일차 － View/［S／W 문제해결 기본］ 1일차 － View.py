case = int(10)

for i in range(case):
  buildingAmount = int(input())
  buildingHeightList = list(map(int, input().split()))
  sum = 0
  for j in range(buildingAmount):
    if (buildingHeightList[j] != 0
        and buildingHeightList[j - 1] < buildingHeightList[j]
        and buildingHeightList[j - 2] < buildingHeightList[j]
        and buildingHeightList[j + 1] < buildingHeightList[j]
        and buildingHeightList[j + 2] < buildingHeightList[j]):
      sum += (buildingHeightList[j] -
              max(buildingHeightList[j - 1], buildingHeightList[j - 2],
                  buildingHeightList[j + 1], buildingHeightList[j + 2]))
  print(f"#{i + 1} {sum}")