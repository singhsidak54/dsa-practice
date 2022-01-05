package misc;

public class AllPermutationsOfString {
    public static void swap(char[] string, int i, int j) {
        char temp = string[i];
        string[i] = string[j];
        string[j] = temp;
    }
    public static void printPermutations(char[] string, int level) {
        if(level == string.length) {
            System.out.println(string);
        }

        for(int i=level; i<string.length; i++) {
            swap(string, level, i);
            printPermutations(string, level + 1);
            swap(string, i, level);
        }
    }

    public static void main(String[] args) {
        printPermutations("ABC".toCharArray(), 0);
    }
}
