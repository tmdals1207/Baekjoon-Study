import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        double[] scores = new double[x];
        double high_num = 0.0;
        double average = 0.0;
        for (int i = 0; i < x; i++) {
            scores[i] = scanner.nextDouble();
        }
        high_num = scores[0];
        
        for(int i = 1; i < x; i++){
            if(scores[i]>high_num){
                high_num = scores[i];
            }
        }
        for(int i = 0; i < x; i++){
            scores[i] = scores[i] / high_num * 100;
            average += scores[i];
        }
        System.out.println(average / x);
    }
}