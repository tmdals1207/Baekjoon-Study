import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        int[] numbers = new int[x];

        int count = 0;
        
        for(int i = 0; i < x; i++){
            numbers[i] = sc.nextInt();
            int number = numbers[i];
            if(sosu(number)){
                count++;
            }
        }
        System.out.println(count);
    }
    
    public static boolean sosu(int n){
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}