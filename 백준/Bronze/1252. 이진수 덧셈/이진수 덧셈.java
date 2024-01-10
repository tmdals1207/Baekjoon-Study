import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();

        int max = Math.max(str1.length(), str2.length());

        int[] int1 = new int[max];
        int[] int2 = new int[max];
        int[] result = new int[max + 1];

        if (str1.length() > str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                int1[i] = Character.getNumericValue(str1.charAt(i));
            }
            for (int j = max - str2.length(); j < max; j++) {
                int2[j] = Character.getNumericValue(str2.charAt(j - (max - str2.length())));
            }
        } else {
            for (int i = 0; i < str2.length(); i++) {
                int2[i] = Character.getNumericValue(str2.charAt(i));
            }
            for (int j = max - str1.length(); j < max; j++) {
                int1[j] = Character.getNumericValue(str1.charAt(j - (max - str1.length())));
            }
        }

        int up = 0;

        for (int i = max - 1; i >= 0; i--) {
            int sum = int1[i] + int2[i] + up;
            
            if (sum == 0) {
                up = 0;
                result[i + 1] = 0;
            } else if (sum == 1) {
                up = 0;
                result[i + 1] = 1;
            } else if (sum == 2) {
                up = 1;
                result[i + 1] = 0;
            } else if (sum == 3) {
                up = 1;
                result[i + 1] = 1;
            }
        }

        result[0] = up;

        while(true){
            if (result[0] == 0 && result.length > 1) {
                int[] finalResult = new int[result.length - 1];
                System.arraycopy(result, 1, finalResult, 0, finalResult.length);
                result = finalResult;
            }
            else
                break;
        }
        
         
        for (int num : result) {
            System.out.print(num);
        }
    }
}
