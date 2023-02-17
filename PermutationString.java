import java.util.*;
public class PermutationString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        if(t<100){
        for(int i=t;i>0;i--) {
            String pattern = sc.next();
            String text = sc.next();
            if(pattern.length()<=1000 && text.length()<=1000)
            System.out.println(findPermutation(pattern, text));
        }
    }
}
 
    public static String findPermutation(String pattern, String text) {
        Set<String> patternPermutations = generatePermutations(pattern);

        for (String p : patternPermutations) {
            if (text.contains(p)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static Set<String> generatePermutations(String pattern) {
        Set<String> result = new HashSet<>();

        if (pattern.length() == 1) {
            result.add(pattern);
            return result;
        }

        char firstChar = pattern.charAt(0);
        String rest = pattern.substring(1);
        Set<String> subPermutations = generatePermutations(rest);

        for (String subPermutation : subPermutations) {
            for (int i = 0; i <= subPermutation.length(); i++) {
                String permutation = subPermutation.substring(0, i) + firstChar + subPermutation.substring(i);
                result.add(permutation);
            }
        }

        return result;
    }
}

