import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class ConnectedComponents {
	private static int numberOfComponents(ArrayList<Integer>[] adj) {
		int result = 0;
		// write your code here

		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		//stack.push(1);
		//int count = 0;

		for (int i = 0; i < adj.length; i++) {
			if(!visited.contains(i)){
				stack.push(i);
				while (!stack.isEmpty()) {
					int cur = stack.pop();
					visited.add(cur);
					for (int v : adj[cur]) {
						if (!visited.contains(v)) {
							stack.push(v);
						}
					}

				}
				result++;
			}
			
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
			adj[y - 1].add(x - 1);
		}
		System.out.println(numberOfComponents(adj));
	}
}
