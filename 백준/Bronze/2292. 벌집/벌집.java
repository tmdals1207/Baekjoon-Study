import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int pass = 1;
        int start = 1;
        int end = 1;

        while (true) {
            if (start <= input && end >= input) {
                break;
            }
            start = end + 1;
            end += + 6 * pass ;
            pass++;
        }
        System.out.println(pass);
    }
}