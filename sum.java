import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class sum {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        scan.nextLine();
        String[] l=scan.nextLine().split(" ");
        int[] list=new int[l.length];
        for (int i=0;i<l.length;i++){
            list[i]=Integer.parseInt(l[i]);
        }
        List<List<Integer>> array=new ArrayList<>();
        for (int i=0;i<list.length-1;i++){
            int j=i+1;
            int k=list.length-1;
        }
        
    }
    
}
