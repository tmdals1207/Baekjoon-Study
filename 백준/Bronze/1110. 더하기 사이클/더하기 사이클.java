import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        int cycle = 0;
        int number = scanner.nextInt();
        int copy = number;
        int num1, num2;
        
        while(true){
            if(number > 9){
            num1 = number / 10;
            num2 = number % 10;
            }
            else{
            num1 = 0;
            num2 = number;
            }
            
            number = num2 * 10 + (num1 + num2) % 10;
            cycle++;

            if(copy == number){
                break;
            }
        }
        
        System.out.println(cycle);
    }
}