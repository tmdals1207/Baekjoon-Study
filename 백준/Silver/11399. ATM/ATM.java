import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> peopleArrayList = new ArrayList<>();

        int n = scanner.nextInt();
        int total = 0;

        for(int i = 0; i < n; i++){
            peopleArrayList.add(scanner.nextInt());
        }

        Collections.sort(peopleArrayList);

        for (int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++){
                total += peopleArrayList.get(j);
            }
        }
        
        System.out.println(total);
    }
}