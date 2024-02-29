import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dice = new int[3];
        for (int i = 0; i < 3; i++) {
            dice[i] = scanner.nextInt();
        }
        
        int prize = 0;
        
        if (dice[0] == dice[1] && dice[1] == dice[2]) {
            prize = 10000 + dice[0] * 1000;
        } 
        else if (dice[0] == dice[1] || dice[1] == dice[2] || dice[0] == dice[2]) {
            prize = 1000 + (dice[0] == dice[1] ? dice[0] : dice[2]) * 100;
        } 
        else {
            prize = Math.max(dice[0], Math.max(dice[1], dice[2])) * 100;
        }
        System.out.println(prize);
    }
}