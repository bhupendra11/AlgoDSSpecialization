import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y,HashSet<Integer> visited) {
        //write your code here
    	
    	if(x==y)return 1;
    	
    	//visit x
    	visited.add(x);
    	
    	//get all adj vertices to x
    	ArrayList<Integer> adjVert = adj[x];
    	
    	for(int v : adjVert){
    		if(!visited.contains(v)){
    		  int res= reach(adj, v, y,visited);
    		  if(res==1)return 1;
    		}
    	}
    	
        return 0;
    }
    
    private static int reach(ArrayList<Integer>[] adj, int x, int y){
    	HashSet<Integer> visited = new HashSet<Integer>();
    	return reach(adj, x, y,visited);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

