import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[2];
        
        for(int i = 0; i < 2 ; i++){
            num[i] = scanner.nextInt();
            num[i] = separateDigits(num[i]);
        }
        if(num[0]>num[1]){
            System.out.println(num[0]);
        }else
          System.out.println(num[1]);  
    }
    
    public static int separateDigits(int number){
        String numString = Integer.toString(number);
        char[] digitArray = numString.toCharArray();
        char c;
        int x;
        for(int i = 0; i < 3; i++){
            c = digitArray[0];
            digitArray[0] = digitArray[2];
            digitArray[2] = c;
        }
        numString = new String(digitArray);
        x = Integer.parseInt(numString);
        return x;
    }
}