import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
        int n = adj.length;
        Queue<Integer> queue = new LinkedList<>();
        
        int dist[] = new int[n];
        for(int i=0;i<n;i++){
        	dist[i] = -1;
        }
        queue.add(s);
        dist[s]=0;
        while(!queue.isEmpty()){
        	int u = queue.poll();
        	for(int v : adj[u]){
        		if(dist[v]==-1){
        			queue.add(v);
            		dist[v]= dist[u]+1;
        		}
        		
        	}
        }
        
        if(dist[t]!= -1) return dist[t];
        return -1;
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
        System.out.println(distance(adj, x, y));
        System.out.println("Path is : ");
        printPath(adj, x, y);
    }
    
    
    private static void printPath(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
        int n = adj.length;
        Queue<Integer> queue = new LinkedList<>();
        
        int dist[] = new int[n];
        int prev[] = new int[n];
        for(int i=0;i<n;i++){
        	dist[i] = -1;
        	prev[i] =-1;
        }
        queue.add(s);
        dist[s]=0;
        prev[s]=s;
        while(!queue.isEmpty()){
        	int u = queue.poll();
        	for(int v : adj[u]){
        		if(dist[v]==-1){
        			queue.add(v);
            		dist[v]= dist[u]+1;
            		prev[v] =u;
        		}
        		
        	}
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        //get prev arry
        while(t != s){
        	path.add(t);
        	t= prev[t];
        }
        path.add(s);
        
        for(int i=path.size()-1 ; i>=0 ;i--){
        	System.out.print((path.get(i)+1)+" ");
        }
        
       return;
    }
}

