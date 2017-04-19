import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
	private static int bipartite(ArrayList<Integer>[] adj) {
		// write your code here
		int WHITE = 222;
		int BLACK = 111;
		int options[] = { WHITE, BLACK };
		int n = adj.length;
		int[] color = new int[n];
		for (int i = 0; i < n; i++) {
			color[i] = -1;
		}
		int choice = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		color[0] = options[choice];

		while (!queue.isEmpty()) {
			int u = queue.poll();
			choice = (choice == 0) ? 1 : 0;
			int curColor = options[choice];
			for (int v : adj[u]) {
				if (color[v] == -1) { // not visited
					color[v] = curColor;
					queue.add(v);
				}

				// int colorSecond = (curColor==WHITE)?BLACK:WHITE;
				else if (color[v] == color[u]) {
					return 0;
				}
			}

		}

		return 1;
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
		System.out.println(bipartite(adj));
	}
}
