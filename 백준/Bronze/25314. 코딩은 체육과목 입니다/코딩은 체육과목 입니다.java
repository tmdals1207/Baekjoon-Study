import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        if (N == 4) {
            System.out.println("long int");
        } 
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N / 4; i++) {
                sb.append("long ");
            }
            sb.append("int");
            System.out.println(sb.toString());
        }
    }
}