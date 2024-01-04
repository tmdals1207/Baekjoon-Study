import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        while(true){
            if(x>0){
                if(y>0){
                    System.out.println("1");
                    break;
                }else {
                    System.out.println("4");
                    break;
                }
            }else{
                if(y>0){
                    System.out.println("2");
                    break;
                }else {
                    System.out.println("3");
                    break;
                }
            }
        }
    }
}