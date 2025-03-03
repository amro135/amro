import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class graph {
     public static void main(String[] args) {



         Scanner scanner = new Scanner(System.in);



         



         int n = scanner.nextInt();



         int m = scanner.nextInt();



         



         List<List<Integer>> graph = new ArrayList<>(n + 1);



         boolean[] visited = new boolean[n + 1];
         int[] deg=new int[n+1];



         



         for (int i = 0; i <= n; i++) {



             graph.add(new ArrayList<>());



         }



         



         for (int i = 0; i < m; i++) {



             int a = scanner.nextInt();



             int b = scanner.nextInt();



             graph.get(a).add(b);



             graph.get(b).add(a); 
             deg[a]++;
             deg[b]++;
        }
        int one =0;int two=0;int max=-1;
        for (int i:deg){
            if (i==1){
                one++;
            }else if (i==2) {
                two++;
            
            if(i>max) {
                max=i;
                
            }

        }
       
        if (two==n-2&&one==2){
            System.out.println("bus topology");

        }else if (two==n){
            System.out.println("ring topology" );

        }else if (max==n-1&&one==n-1){
            System.out.println("star topology"  );

        }else{
            System.out.println("unknown topology" );
        }
    }



}
    

