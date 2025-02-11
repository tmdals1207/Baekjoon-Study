import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //GPT의 도움을 받음
	
	static int N;
	static int[] acidity;  // 신맛
	static int[] acerbity; // 쓴맛
	static int min = Integer.MAX_VALUE; // 최소 차이값 저장
	
	static void dfs(int idx, int sTotal, int bTotal, int count) {
		// 최소 하나 이상의 재료를 선택했을 때만 min 값을 갱신
		if (count > 0) {
			min = Math.min(min, Math.abs(sTotal - bTotal));
		}
		
		// 모든 재료를 확인했으면 종료
		if (idx == N) return;
		
		// 현재 재료를 선택하는 경우
		dfs(idx + 1, sTotal * acidity[idx], bTotal + acerbity[idx], count + 1);
		
		// 현재 재료를 선택하지 않는 경우
		dfs(idx + 1, sTotal, bTotal, count);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		acidity = new int[N];
		acerbity = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			acidity[i] = Integer.parseInt(st.nextToken()); // 신맛
			acerbity[i] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		
		// DFS 탐색 (인덱스 0부터 시작, 초기 신맛은 1, 쓴맛은 0, 선택 개수 0)
		dfs(0, 1, 0, 0);
		
		System.out.println(min);
	}
}

//초기 상태: dfs(0, 1, 0, 0)  // 신맛=1, 쓴맛=0, 선택 개수=0
//
//1번 재료를 선택한 경우: dfs(1, 1×1=1, 0+7=7, 1)
//    2번 선택: dfs(2, 1×2=2, 7+6=13, 2)
//        3번 선택: dfs(3, 2×3=6, 13+8=21, 3)
//            4번 선택: dfs(4, 6×4=24, 21+9=30, 4) → min 갱신 (|24-30|=6)
//            4번 선택 안함: dfs(4, 6, 21, 3) → min 갱신 (|6-21|=15)
//        3번 선택 안함: dfs(3, 2, 13, 2)
//            4번 선택: dfs(4, 2×4=8, 13+9=22, 3) → min 갱신 (|8-22|=14)
//            4번 선택 안함: dfs(4, 2, 13, 2) → min 갱신 (|2-13|=11)
//    2번 선택 안함: dfs(2, 1, 7, 1)
//        3번 선택: dfs(3, 1×3=3, 7+8=15, 2)
//            4번 선택: dfs(4, 3×4=12, 15+9=24, 3) → min 갱신 (|12-24|=12)
//            4번 선택 안함: dfs(4, 3, 15, 2) → min 갱신 (|3-15|=12)
//        3번 선택 안함: dfs(3, 1, 7, 1)
//            4번 선택: dfs(4, 1×4=4, 7+9=16, 2) → min 갱신 (|4-16|=12)
//            4번 선택 안함: dfs(4, 1, 7, 1) → min 갱신 (|1-7|=6)
//
//1번 재료를 선택 안 한 경우: dfs(1, 1, 0, 0)
//    (이후 동일한 방식으로 탐색)