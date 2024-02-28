import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String octal = scanner.nextLine();
        StringBuilder binary = new StringBuilder();
        
        for (int i = 0; i < octal.length(); i++) {
            int digit = octal.charAt(i) - '0';
            String binaryDigit = Integer.toBinaryString(digit);
            
            if (i != 0 && binaryDigit.length() < 3) {
                int numOfZeros = 3 - binaryDigit.length();
                for (int j = 0; j < numOfZeros; j++) {
                    binary.append('0');
                }
            }
            binary.append(binaryDigit);
        }
        System.out.println(binary);
    }
}