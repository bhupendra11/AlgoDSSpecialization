import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
    	int n = adj.length;
        int used[] = new int[n];
        for(int i=0;i<used.length;i++){
        	used[i] = 0;
        }
        ArrayList<Integer> order = new ArrayList<Integer>();
        //write your code here
        Map<Integer, Integer> postOrder = new LinkedHashMap<Integer,Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        int count =0;
        
        for(int i=0;i<n;i++){
        	if(used[i] ==0)
        		 dfs(adj,count,postOrder,i,used);
        }
       
        
        Stack<Integer> res = new Stack<>();
        
        Iterator<Integer> iterator = postOrder.keySet().iterator();
        
        while(iterator.hasNext()){
        	int item = iterator.next();
        	res.push(item);
        	//System.out.println(postOrder.get(item));
        }
        
        while(!res.empty()){
        	order.add(res.pop());
        }
        
        
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int count,Map<Integer, Integer> postOrder, int s,int[] used  ) {
      //write your code here
    	 
    		used[s] = 1; 
             
    	
    		ArrayList<Integer> nbrs = adj[s];
    		for(int n: nbrs){
    			if(used[n]==0){ //not visited
    				dfs(adj,count,postOrder,n,used);
    			} 			    			
    		}
    		postOrder.put(s, count);
			count++;
    	
    	
    	
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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}


