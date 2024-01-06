import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        char[][] array = new char[15][15];

        for (int i = 0; i < 15; i++) {
            if (scanner.hasNext()) {
                String input = scanner.next();
                for (int j = 0; j < input.length(); j++) {
                    array[i][j] = input.charAt(j);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j][i] == '\0')
                    continue;
                else
                    result.append(array[j][i]);  
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
