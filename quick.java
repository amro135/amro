import java.util.Arrays;
import java.util.Scanner;

public final class quick {

 
    static int first_index(int[] array, int val, int left, int right, int result) {
        if (left > right) {
            return result;
        }
        int mid = (left + right) / 2;
        if (array[mid] >= val) {
            result = mid; 
            return first_index(array, val, left, mid - 1, result); 
        } else {
            return first_index(array, val, mid + 1, right, result);
        }
    }

  
    static int last_index(int[] array, int val, int left, int right, int result) {
        if (left > right) {
            return result;
        }
        int mid = (left + right) / 2;
        if (array[mid] <= val) {
            result = mid;  
            return last_index(array, val, mid + 1, right, result);
        } else {
            return last_index(array, val, left, mid - 1, result);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        scan.nextLine();
        String[] a1 = scan.nextLine().split(" ");
        int[] array = new int[a];

        for (int i = 0; i < a; i++) {
            array[i] = Integer.parseInt(a1[i]);
        }

        Arrays.sort(array); 

        int n = scan.nextInt();
        scan.nextLine();

        StringBuilder st = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] f = scan.nextLine().split(" ");
            int l = Integer.parseInt(f[0]);
            int k = Integer.parseInt(f[1]);

            int first = first_index(array, l, 0, a - 1, a); 
           
            int last = last_index(array, k, 0, a - 1, -1); 

            if (first > last) {
                st.append("0 "); 
            } else {
                st.append((last - first + 1)).append(" ");
            }
        }

        System.out.println(st.toString().trim());
        scan.close();
    }
}
