import java.util.*;
class Main{
    static int MAX = 300004;
    static ArrayList<ArrayList<Integer>> graph;
    static long mod = (long)1e9 + 7;
    static int ans = 0;
    static int countSubtreesUtil(int cur, int par) {
    	
    	int res = 1;
        for(int i = 0;i < graph.get(cur).size(); i++) {
    		int v = graph.get(cur).get(i);
    		if (v == par) continue;
            res = (int)((res * (countSubtreesUtil(v, cur) + 1)) % mod);
    	}
    	ans = (int)((ans + res) % mod);
        return res;
    }
    static void countSubtrees(int N, int[][] adj) {
    	
    	for(int i = 0; i < N - 1; i++) {
    		int a = adj[i][0];
    		int b = adj[i][1];
    		graph.get(a).add(b);
    		graph.get(b).add(a);
    	}
    	countSubtreesUtil(1, 1);
        System.out.println(ans + 1);
    }
    
    public static void main(String[] args) {
    	int N = 3;
    	int[][] adj = { { 0, 1 }, { 1, 2 } };
    	graph = new ArrayList<>();
    	for(int i = 0; i < MAX; i++) graph.add(new ArrayList<>());
    	countSubtrees(N, adj);
    }
}
