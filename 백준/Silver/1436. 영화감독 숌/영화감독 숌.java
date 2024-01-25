import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int count = 0;
        int number = 0;
        
        while (true) {
            
            if(contains666(number)){
                count++;
                if(x != count){
                    number++;
                }
                else{
                    break;
                }    
            }
            else{
                number++;
            }
        }

        System.out.println(number);
    
    }

    private static boolean contains666(int n) {
        String numberStr = Integer.toString(n);
        return numberStr.contains("666");
    }
}
