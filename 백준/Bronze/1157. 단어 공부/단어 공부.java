import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.next();
        String upperStr = str.toUpperCase();
        char[] ch = upperStr.toCharArray();

        char[][] alphabet = new char[26][2];

        for(int i = 0; i < 26; i++){
            alphabet[i][0] = (char) ('A' + i);
            alphabet[i][1] = 0;
        }

        for(int i = 0; i <str.length(); i++){
            for(int j = 0; j < 26; j++){
                if(alphabet[j][0] == ch[i]){
                    alphabet[j][1] += 1;
                }
            }
        }
        int max = 0;
        char fin = 'a';
        for(int i = 0; i < 26; i++){
            if(max < alphabet[i][1]){
                max = alphabet[i][1];
                fin = alphabet[i][0];
            }
        }

        for(int i = 0; i < 26; i++){
            if(max == alphabet[i][1] && max != 0 && alphabet[i][0] != fin){
                fin = '?';
            }
        }
        
        System.out.println(fin);
        scanner.close();
    }
}