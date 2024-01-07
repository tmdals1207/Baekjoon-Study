import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 0;
        int y = 0;
        
        if(!isPossibleWith3And5(n)){
                System.out.println("-1");
            }
        else{
            System.out.println(calculator(n));
        }
    }
    
    public static int calculator(int num) {
        int max = num / 5;
        for(int i = max; i >= 0; i--){
            int remainer = num - (i * 5);
            if(remainer % 3 == 0){
                return (i + (remainer / 3));
            }
        }
        return -1;
    }
    
    public static boolean isPossibleWith3And5(int num) {
        for (int x = 0; 3 * x <= num; x++) {
            for (int y = 0; 5 * y <= num; y++) {
                if (3 * x + 5 * y == num) {
                    return true;
                }
            }
        }
        return false;
    }
}