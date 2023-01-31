package daily.jan23;

public class Day14LexicographicallySmallestEquivalentString {
    static int[] parent;

    public static int find(int u) {
        if(parent[u] != u) {
            parent[u] = find(parent[u]);
            return parent[u];
        }

        return u;
    }

    public static void union(int u, int v) {
        int uParent = find(u);
        int vParent = find(v);

        if(uParent == vParent) return;

        if(uParent < vParent) {
            parent[vParent] = uParent;
        } else {
            parent[uParent] = vParent;
        }
    }
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        for(int i=0; i<26; i++) {
            parent[i] = i;
        }

        for(int i=0; i<s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder result = new StringBuilder();
        for(char c : baseStr.toCharArray()) {
            char sorted = (char) ('a' + find(parent[c - 'a']));
            result.append(sorted);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("hello", "world", "hold"));
    }
}
