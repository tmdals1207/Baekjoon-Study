import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int result = buyBottle(n, k);

        System.out.println(result);
        sc.close();
    }
    
    public static int buyBottle(int n, int k){
        
        if(n <= k) return 0;

        int buy = 0;
        while(true) {
            int bottle = n + buy;
            int count = 0;
            while(bottle > 0) {
                if(bottle % 2 != 0) {
                    count++;
                }
                bottle /= 2;
            }
            if(count <= k){
                break;
            }             
            buy++;
        }
        return buy;
    }
}
