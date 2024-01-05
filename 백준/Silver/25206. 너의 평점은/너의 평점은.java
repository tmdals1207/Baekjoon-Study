import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        String[] subjects = new String[20];
        double[] grades = new double[20];
        double[] ratings = new double[20];
        
        double total = 0;
        double total_grades = 0;
        
        for (int i = 0; i < 20; i++){
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parts[2].equals("P")){
                continue;
            }
            switch (parts[2]) {
                case "A+":
                    parts[2] = "4.5";
                    break;
                case "A0":
                    parts[2] = "4.0";
                    break;
                case "B+":
                    parts[2] = "3.5";
                    break;
                case "B0":
                    parts[2] = "3.0";
                    break;
                case "C+":
                    parts[2] = "2.5";
                    break;
                case "C0":
                    parts[2] = "2.0";
                    break;
                case "D+":
                    parts[2] = "1.5";
                    break;
                case "D0":
                    parts[2] = "1.0";
                    break;
                case "F":
                    parts[2] = "0";
                    break;
                default:
                    parts[2] = "0.0";
            }
            subjects[i] = parts[0];
            grades[i] = Double.parseDouble(parts[1]);
            ratings[i] = Double.parseDouble(parts[2]);
            total += (grades[i]*ratings[i]);
            total_grades += grades[i];
        }
        double average = total / total_grades;
        System.out.println(average);
    }
}