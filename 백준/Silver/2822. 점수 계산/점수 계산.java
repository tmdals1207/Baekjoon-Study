import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] scores = new int[8];
        for (int i = 0; i < 8; i++) {
            scores[i] = sc.nextInt();
        }
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);
        int total = 0;
        StringBuilder indexes = new StringBuilder();

        for (int i = 3; i < 8; i++) {
            total += sortedScores[i];
            indexes.append(indexOf(scores, sortedScores[i]) + 1);

            if (i < 7) {
                indexes.append(" ");
            }
        }

        String[] sortedIndexesArray = indexes.toString().split(" ");
        Arrays.sort(sortedIndexesArray);

        StringBuilder sortedIndexes = new StringBuilder();
        for (int i = 0; i < sortedIndexesArray.length; i++) {
            sortedIndexes.append(sortedIndexesArray[i]);
            if (i < sortedIndexesArray.length - 1) {
                sortedIndexes.append(" ");
            }
        }

        System.out.println(total);
        System.out.println(sortedIndexes);
    }

    private static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
