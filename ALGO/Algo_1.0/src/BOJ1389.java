import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class pair {
    int now;
    int weight;
    public pair(int now, int weight) {
        super();
        this.now = now;
        this.weight = weight;
    }
}
 
public class BOJ1389 {
    static int n,m;
    static boolean[][] map;
 
    static int[] rst;
    static Scanner sc = new Scanner(System.in);
 
    static int bfs(int start) {
        boolean[] visited = new boolean[n+1];
        Queue<pair> q = new LinkedList<pair>();
        visited[start]=true;
        q.add(new pair(start,0));
        int score=0;
        
        while(!q.isEmpty()) {
            int now = q.peek().now;
            int weight = q.peek().weight;
            score+=weight;
            q.poll();
            
            for(int i=1;i<=n;i++) {
                if(map[now][i] && !visited[i]) {
                    visited[i]=true;
                    q.add(new pair(i,weight+1));
                }
            }
        }
        
        return score;
    }
    
    public static void main(String[] args) {
        n = sc.nextInt(); // 유저의 수
        m = sc.nextInt(); // 관계 수
        
        map = new boolean[n+1][n+1];
        rst = new int[n+1];
        
        for(int i=0;i<m;i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            
            map[a][b] = true;
            map[b][a] = true;
        }
        
        int min=Integer.MAX_VALUE;
        int ans = 0;
        for(int i=1;i<=n;i++) {
            
            rst[i] = bfs(i);
            
            if(rst[i]<min) {
                min = rst[i];
                ans = i;
            }
        }
        
        System.out.println(ans);
        
    }//end of main
}
 