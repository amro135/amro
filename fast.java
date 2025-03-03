
// SOLUTION HANDELING NNEGATIVE INPUT 
import java.util.Scanner;

public final class fast {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int var2 = scan.nextInt();
      scan.nextLine();
      int  max=Integer.MIN_VALUE;
      String[] var3 = scan.nextLine().split(" ");
      int[] array = new int[var2];
      for(int i = 0; i < var2; ++i) {
        array[i] = Integer.parseInt(var3[i]);
      }
      for (int i:array){
        if (i>max){
            max=i;
        }

      }
      int[] freq=new int[max+1];
      int[] freq2=new int[max+1];
      for (int i=0;i<var2;i++){
        if (array[i]<0){
            freq2[Math.abs(array[i])]++;

        }else {
            freq[array[i]]++;
        }
        
      }
      StringBuilder st=new StringBuilder();
      for (int i=0;i<=max;i++){
        if (freq2[i]!=0){
            for ( int j=0;j<freq2[i];j++){
                st.append(i*-1).append(" ");

            }
            
        }
      }
      for (int i=0;i<=max;i++){
        if (freq[i]!=0){
            for ( int j=0;j<freq[i];j++){
                st.append(i).append(" ");

            }
            
        }
      }
      System.out.println(st);
      for (int i=0;i<max;i++ ){
        if (freq2[i]!=0){
            System.out.printf("%d %d\n",-1*i,freq2[i]);

        }
        
      }
      for (int i=0;i<freq.length;i++ ){
        if (freq[i]!=0){
            System.out.printf("%d %d\n",i,freq[i]);

        }
        
      }

     

    }
    
}
