import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = new int[8];
        
        for(int i = 0; i < 8; i++){
            arr[i] = scanner.nextInt();
        }
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        Integer[] numbersAsObjects = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Integer[] desortedArr = Arrays.copyOf(numbersAsObjects, numbersAsObjects.length);
        Arrays.sort(desortedArr, java.util.Collections.reverseOrder());
        
        boolean ascending = Arrays.equals(arr, sortedArr);
        boolean descending = Arrays.equals(numbersAsObjects, desortedArr);

        if (ascending) {
            System.out.println("ascending");
        } else if (descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}