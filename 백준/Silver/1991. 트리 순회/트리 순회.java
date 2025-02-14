import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static Node nodes[];
	
	static void preorder(Node node) {
		System.out.print(node.value);
		if(node.left!=null) preorder(node.left);
		if(node.right!=null) preorder(node.right);
	}
	
	static void inorder(Node node) {
		if(node.left!=null) inorder(node.left);
		System.out.print(node.value);
		if(node.right!=null) inorder(node.right);
	}

	static void postorder(Node node) {
		if(node.left!=null) postorder(node.left);
		if(node.right!=null) postorder(node.right);
		System.out.print(node.value);
	}
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node((char) ('A'+i));
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			Node cur =  nodes[node-'A'];
			cur.left = (left!='.') ? nodes[left-'A']:null;
			cur.right = (right!='.') ? nodes[right-'A']:null;
			
		}
		
		preorder(nodes[0]);
		System.out.println();
		inorder(nodes[0]);
		System.out.println();
		postorder(nodes[0]);
		br.close();
		
	}

}

class Node {
    char value;
    Node left, right;

    Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}