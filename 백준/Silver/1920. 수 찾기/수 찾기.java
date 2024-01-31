import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> originalSet = new HashSet<>();
        List<Integer> compareList = new ArrayList<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            originalSet.add(scanner.nextInt());
        }

        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            compareList.add(scanner.nextInt());
        }

        for (int i = 0; i < m; i++) {
            if (originalSet.contains(compareList.get(i))) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}