import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static Node[] nodes;
	static BufferedWriter bw;
	
	
	static void preorder(Node node) throws IOException {
		bw.write(node.data);
		if(node.left!=null) preorder(node.left);
		if(node.right!=null) preorder(node.right);
	}
	
	static void inorder(Node node) throws IOException {
		if(node.left!=null) inorder(node.left);
		bw.write(node.data);
		if(node.right!=null) inorder(node.right);	
	}
	
	static void postorder(Node node) throws IOException {
		if(node.left!=null) postorder(node.left);
		if(node.right!=null) postorder(node.right);
		bw.write(node.data);
	}	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		nodes = new Node[N];
		
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node((char) ('A'+i));
		}
		
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			Node cur =  nodes[node-'A'];
			cur.left = (left!='.') ? nodes[left-'A']:null;
			cur.right = (right!='.') ? nodes[right-'A']:null;
			
		}
		
		preorder(nodes[0]);
		bw.write("\n");
		bw.flush();
		inorder(nodes[0]);
		bw.write("\n");
		bw.flush();
		postorder(nodes[0]);
		bw.close();
	}

}


class Node {
	char data;
	Node left, right;
	
	public Node (char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}