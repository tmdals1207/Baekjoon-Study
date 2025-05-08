import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N == 2 일때
// 1. "daldi" 까지는 하나씩 쳐서 cnt = 5
// 2. "daldidal" 까지는 앞에 쳤던 dal을 복사 후 맨 뒤에 붙여넣으니 cnt = 6
// 3. "daldidalgo" 까지는 "daldidal" 후에 "go"는 하나씩 쳐서 cnt = 8
// 4. N이 2였으니 "daldidalgo"가 2번 나와야하고 미리 완성한 "daldidalgo"를 이어 붙여서 cnt = 9
// 5. "daldidan"이 나와야하니 "daldidalgo"의 "daldida"까지 복사 후 맨 뒤에 붙여 넣어서 cnt = 10
// 6. "daldida"에 "n"을 붙여서 "daldidan" 완성 cnt = 11
// 즉 "daldidalgo" 를 완성하기까지 걸리는 초는 8초, "daldidan"을 완성하기까지 걸리는 초는 2초
// 총 10초에 "daldidalgo"가 2의 몇제곱인지 알아내고 딱 떨어지면 해당 수만큼 더하고 아니면 해당 수 + 1을 더함

public class Main {

    static int N;

    static int bb() {

        double value = Math.log(N) / Math.log(2);
        int count = 0;
        
        while(N>1){
           N/=2;
           count++;
        }
        return count + 10;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        System.out.println(bb());
    }
}