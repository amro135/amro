import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class twopointers {
    public static void main(String[] args) {
        int[] a=nums;
        List<List<Integer>> array = new ArrayList<>();
        Arrays.sort(a);
        for(int i=0;i<a.length-1;i++){
            int j=i+1;
            int k=a.length-1;
            while(j<k){
                int sum=a[i]+a[j]+a[k];
                if (sum==0){
                    array.add(Arrays.asList(a[i],a[j],a[k]));
                    j++;
                    while(a[j]==a[j-1]&& j<k){
                        j++;
                    }
                }else if(sum<0){
                    j++;
                }else{
                    k--;
                }

            }

        }
        return array;
    
    }

    
    
    
}
