import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        while (true) {
            number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            if (isPalindrome(number)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isPalindrome(int n) {
        int[] numbers = getDigitsArray(n);
        int len = numbers.length;

        for (int i = 0; i < len / 2; i++) {
            if (numbers[i] != numbers[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getDigitsArray(int number) {
        String numberStr = Integer.toString(number);
        int[] numbers = new int[numberStr.length()];

        for (int i = 0; i < numberStr.length(); i++) {
            numbers[i] = Character.getNumericValue(numberStr.charAt(i));
        }
        return numbers;
    }
}
