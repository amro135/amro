import java.util.ArrayList;
import java.util.Arrays;

class Anagram {
    String anagram;
    ArrayList<String> array = new ArrayList<>();

    Anagram(String anagram) {
        this.anagram = anagram;
        array.add(anagram);
    }

    // This method checks if anagram1 is an anagram of the current anagram
    boolean isAnagram(String anagram1) {
        // If the lengths are not equal, they can't be anagrams
        if (anagram1.length() != this.anagram.length()) {
            return false;
        }

        // Sort both strings and compare them
        char[] chars1 = anagram1.toCharArray();
        char[] chars2 = this.anagram.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);





        
    }

    ArrayList<String> getarray() {
        return this.array;
    }
}

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];  // Track visited strings

        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {  // If the string is not visited
                String anagram = strs[i];
                Anagram anagramObj = new Anagram(anagram);
                visited[i] = true;

                // Try to group all anagrams of the current string
                for (int j = i + 1; j < strs.length; j++) {
                    if (!visited[j] && anagramObj.isAnagram(strs[j])) {
                        anagramObj.getarray().add(strs[j]);
                        visited[j] = true;  // Mark this string as visited
                    }
                }
                answer.add(anagramObj.getarray());  // Add the group of anagrams to the result
            }
        }

        // Print the grouped anagrams
        System.out.println(answer);
    }
}
