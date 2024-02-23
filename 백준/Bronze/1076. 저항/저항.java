import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        HashMap<String, Integer> resistors = new HashMap<>();
        
        resistors.put("black", 0);
        resistors.put("brown", 1);
        resistors.put("red", 2);
        resistors.put("orange", 3);
        resistors.put("yellow", 4);
        resistors.put("green", 5);
        resistors.put("blue", 6);
        resistors.put("violet", 7);
        resistors.put("grey", 8);
        resistors.put("white", 9);

        String first = scanner.next();
        String second = scanner.next();
        String third = scanner.next();

        long resist = (long)(resistors.get(first) * 10 + resistors.get(second)) * (int)Math.pow(10, resistors.get(third));

        System.out.println(resist);
    }
}