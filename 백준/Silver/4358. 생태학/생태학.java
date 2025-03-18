import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.TreeMap;

public class Main {

    static TreeMap<String, Integer> trees;

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        trees = new TreeMap<>();
        
        DecimalFormat df = new DecimalFormat("0.0000");
        double cnt = 0.0;
        
        while(true) {
            String input = br.readLine();
            
            if (input == null || input.isEmpty()) break;
            cnt++;
            trees.put(input, trees.getOrDefault(input, 0) + 1);
        }
       while (!trees.isEmpty()) {
            bw.write(trees.firstKey() + " " + df.format(trees.get(trees.firstKey())/cnt*100) + "\n");
            trees.pollFirstEntry();
       }
       bw.flush();
    }
}