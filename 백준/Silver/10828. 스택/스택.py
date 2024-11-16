import sys
input = sys.stdin.read
output = sys.stdout.write

def main():
    data = input().splitlines() 
    count = int(data[0])         
    result = []                  

    stack = []

    for i in range(1, count + 1):
        order = data[i]
        if order.startswith("push"):
            _, num = order.split(" ")
            stack.append(num)
        elif order == "pop":
            if stack:
                result.append(stack.pop())
            else:
                result.append("-1")
        elif order == "size":
            result.append(str(len(stack)))
        elif order == "empty":
            if stack:
                result.append("0")
            else:
                result.append("1")
        elif order == "top":
            if stack:
                result.append(stack[-1])
            else:
                result.append("-1")

    output("\n".join(result) + "\n")

if __name__ == "__main__":
    main()