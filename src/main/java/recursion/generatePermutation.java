package recursion;

import java.util.HashSet;

//https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
public class generatePermutation {

    public static String[] generatePermutation(String s) {
        char[] str = s.toCharArray();
        StringBuilder path = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        f1(str, 0, path, set);
        int n = set.size();
        String[] ans = new String[n];
        int i = 0;
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }

    public static void f1(char[] s, int i, StringBuilder path, HashSet<String> set) {
        if (i == s.length) {
            set.add(path.toString());
        } else {
            path.append(s[i]);
            f1(s, i + 1, path, set);
            path.deleteCharAt(path.length() - 1);
            f1(s, i + 1, path, set);
        }
    }

    public static void f2(char[] s, int i, int size, char[] path, HashSet<String> set) {
        if (i == s.length) {
            //String.valueOf:从索引0开始取size个字符
            set.add(String.valueOf(path, 0, size));
        } else {
            path[size] = s[i];
            f2(s, i + 1, size + 1, path, set);
            f2(s, i + 1, size, path, set);
        }
    }
}
