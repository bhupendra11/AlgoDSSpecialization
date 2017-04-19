import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, 
    		int s, int t) {
    	
    	if(s==t)return 0;
    	int n = adj.length;
        int prev[] = new int[n];
        int dist[] = new int[n];
        for(int i=0;i<n;i++){
        	dist[i] = Integer.MAX_VALUE;
        	prev[i] =-1;
        }
        dist[s] =0;
        
        ArrayList<Integer> nodes = adj[s];
        
        HashMap<Integer, Integer> queue = new HashMap<Integer, Integer>();
        
       
        
        for(int i=0;i<n;i++){
        	queue.put(i, dist[i]);
        }
        queue.put(s	, dist[s]);
       /* for(int v : nodes){
        	
        }*/
        
        while(!queue.isEmpty()){
        	int u = extractMin(queue,dist);
        	queue.remove(u);
            ArrayList<Integer> nbrs = adj[u];
            int ctIndex =0;
            for(int v: nbrs){
            	if(dist[v] > dist[u] + cost[u].get(ctIndex)){
            		dist[v] = dist[u] + cost[u].get(ctIndex);
            		prev[v] = u;
            		
            	}
            	ctIndex++;
            }
        	
        }
    	
    	
    	
    	
    	
    	
    	//if unable to reach
    	if(dist[t]==Integer.MAX_VALUE)return -1;
    	
    	return dist[t];
    }
    
    private static int extractMin(HashMap<Integer, Integer> map, int dist[]){
    	int minDistKey =1;
    	int minDistValue = Integer.MAX_VALUE;
    	for(int i:map.keySet()){
    		if(dist[i] < minDistValue  || minDistValue==Integer.MAX_VALUE){
    			minDistKey = i;
    			minDistValue = dist[i];
    		}
    	}
    	//map.remove(minDistKey);
    	
    	return minDistKey;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

