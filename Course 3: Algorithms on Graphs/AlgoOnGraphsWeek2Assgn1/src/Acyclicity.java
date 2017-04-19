import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Acyclicity {
	private static int acyclic(ArrayList<Integer>[] adj) {
		// write your code here
		Stack<Integer> stack = new Stack<>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < adj.length; i++) {
			if (!visited.contains(i)) {
				if (stack.contains(i)) {
					return 1;
				}
				stack.push(i);
				visited.add(i);
				while (!stack.empty()) {
					int n = stack.pop();
					
					visited.add(n);
					for (int v : adj[n]) {
						if (v==i || v==n ||stack.contains(v)) {
							return 1;
						}
						if (!visited.contains(v))
							stack.push(v);
					}		

				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
	    for(int p=0;p<t;p++){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) {
				int x, y;
				x = scanner.nextInt();
				y = scanner.nextInt();
				adj[x - 1].add(y - 1);
			}
			int res =acyclic(adj);
			System.out.println((res==0)?1:0);
		}
		
	}
}






