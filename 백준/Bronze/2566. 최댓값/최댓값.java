import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[9][9];
        int maximum = 0;
        int x = 1;
        int y = 1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = scanner.nextInt();
                if (maximum < array[i][j]){
                    maximum = array[i][j];
                    x = i + 1;
                    y = j + 1;
                }                    
            }
        }
        System.out.println(maximum);
        System.out.println(x +" "+ y);
        scanner.close();
    }
}