import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after reading t
        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}