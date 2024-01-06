import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int array[][] = new int[num][2];
        
        for(int i = 0; i < num; i++){
            for(int j = 0; j < 2; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        
        for (int i = 0; i < num; i++) {
            int n = array[i][1];
            int m = array[i][0];

            BigInteger result = calculateCombination(n, m);
            System.out.println(result);
        }
        System.out.println();
        scanner.close();
    }
    public static BigInteger calculateCombination(int n, int m) {
        BigInteger numerator = calculateFactorial(n);
        BigInteger denominator = calculateFactorial(m).multiply(calculateFactorial(n - m));

        return numerator.divide(denominator);
    }

    public static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
