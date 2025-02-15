import java.util.Scanner;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException{
        
        Scanner scan = new Scanner(System.in);
        
        String s = scan.nextLine();
        
        System.out.println(s.length());
        
        scan.close();
    }
}