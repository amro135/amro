
import java.util.Scanner;

public final class min_difference {
    static void swap(int [] array ,int i,int j){
        
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    static void merged(int[] array,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[] array1=new int[n1];

        int[] array2=new int[n2];
        System.arraycopy(array, left, array1, 0, n1);
        System.arraycopy(array, mid+1, array2, 0, n2);
        int i=0,j=0,k=left;
        while(i<n1&&j<n2){
            if(array1[i]<array2[j]){
                array[k]=array1[i];
                k++;
                i++;
            }else{
                array[k]=array2[j];
                k++;
                j++;
            }

        }
        while(i<n1){
            array[k]=array1[i];
            k++;
            i++;
        }
        while(j<n2){
            array[k]=array2[j];
            k++;
            j++;
        }

    }
    static void merge(int array[],int left,int right){
        if (left<right){
            int mid=(left+right)/2;
            merge(array,left,mid);
            merge(array,mid+1,right);
            merged(array,left,mid,right);

        }
 

    }
    // static int partition(int[] array,int left, int right){
    //     int i=left-1;
    //     int pivot=array[right];
        
    //     for (int j=left;j<right;j++){
    //         if (array[j]<=pivot){
    //             i++;
    //             swap(array,i,j);
                
    //         }
    //     }
    //     i++;
    //     swap(array,i,right);
    //     return i;

    // }
    // static void quick_sort(int[] array,int left,int right){
    //     if (left>=right){
    //         return;
    //     }
    //     int pivot=partition(array,left,right);
    //     quick_sort(array, left, pivot-1);
    //     quick_sort(array, pivot+1, right);
        

    // }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        scan.nextLine();
        String[] a1=scan.nextLine().split(" ");
        int[] array=new int[a];
        for(int i=0;i<a;i++){
            array[i]=Integer.parseInt(a1[i]);
        }
        // quick_sort(array,0,array.length-1);
        merge(array, 0, array.length-1);
        int min_d=Integer.MAX_VALUE;
        // System.out.println(Arrays.toString(array));
        for(int i=1;i<a;i++){
            if (Math.abs(array[i]-array[i-1])<min_d){
                min_d=Math.abs(array[i]-array[i-1]);
            }
        }
        System.out.println(min_d);

        
    }
    
}
