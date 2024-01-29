import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();

        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= x; i++) {
            numbers.add(i);
        }

        while (numbers.size() > 1) {
            numbers.removeFirst();
            numbers.addLast(numbers.removeFirst());
        }

        System.out.println(numbers.getFirst());
    }
}
