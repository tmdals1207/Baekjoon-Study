import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int time = scanner.nextInt();

        minute += time;
        hour += minute / 60;
        minute %= 60;
        hour %= 24;

        System.out.println(hour + " " + minute);
    }
}