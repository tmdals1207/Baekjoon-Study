public class Main {
    public static void main(String[] args) {
        boolean[] isSelfNumber = new boolean[10001];
        
        for (int i = 1; i <= 10000; i++) {
            int selfNumber = generateSelfNumber(i);
            if (selfNumber <= 10000) {
                isSelfNumber[selfNumber] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!isSelfNumber[i]) {
                System.out.println(i);
            }
        }
    }

    private static int generateSelfNumber(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}